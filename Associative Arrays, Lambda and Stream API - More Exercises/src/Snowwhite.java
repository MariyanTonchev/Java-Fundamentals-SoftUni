import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Snowwhite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, LinkedHashMap<String, Integer>> dwarfs = new LinkedHashMap<>();
        while (!input.equals("Once upon a time")) {
            String[] data = input.split(" <:> ");
            String name = data[0];
            String color = data[1];
            int physics = Integer.parseInt(data[2]);
            dwarfs.putIfAbsent(color, new LinkedHashMap<>());
            dwarfs.get(color).putIfAbsent(name, physics);
            if (dwarfs.get(color).get(name) < physics) {
                dwarfs.get(color).put(name, physics);
            }
            input = scanner.nextLine();
        }
        Map<String, Integer> dwarfsCountHats = new LinkedHashMap<>();
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : dwarfs.entrySet()) {
            for (Map.Entry<String, Integer> entry1 : entry.getValue().entrySet()) {
                dwarfsCountHats.put(entry.getKey() + " - " + entry1.getKey() + " - " + entry.getValue().size(), entry1.getValue());
            }
        }
        dwarfsCountHats.entrySet().stream().sorted((f, s) -> {
            int result = Integer.compare(s.getValue(), f.getValue());
            if (result == 0) {
                String[] result1 = f.getKey().split(" - ");
                String[] result2 = s.getKey().split(" - ");
                result = result2[2].compareTo(result1[2]);
            }
            return result;
        }).forEach(a -> {
            String[] strings = a.getKey().split(" - ");
            System.out.printf("(%s) %s <-> %d%n", strings[0], strings[1], a.getValue());
        });
    }
}