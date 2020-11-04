import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> items = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("Craft!")){
            String[] data = input.split(" - ");
            switch (data[0]){
                case "Collect":
                    collect(items, data[1]);
                    break;
                case "Drop":
                    items.remove(data[1]);
                    break;
                case "Combine Items":
                    String[] data2 = data[1].split(":");
                    combine(items, data2);
                    break;
                case "Renew":
                    renew(items, data[1]);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(items.toString().replaceAll("[\\[\\]]", " ").trim());
    }

    private static void collect(List<String> list, String item){
        if (!list.contains(item)){
            list.add(item);
        }
    }

    private static void combine(List<String> list, String[] data){
        String oldItem = data[0];
        String newItem = data[1];
        if(list.contains(oldItem)){
            list.add(list.indexOf(oldItem) + 1, newItem);
        }
    }

    private static void renew(List<String> list, String item){
        if (list.contains(item)){
            list.remove(item);
            list.add(item);
        }
    }
}
