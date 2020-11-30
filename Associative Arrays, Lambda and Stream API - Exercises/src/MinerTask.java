import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();
        while (!input.equals("stop")) {
            int amount = Integer.parseInt(scanner.nextLine());
            if (resources.containsKey(input)) {
                resources.put(input, resources.get(input) + amount);
            } else {
                resources.put(input, amount);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
