import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] command = input.split(" ");
            String cmd = command[0];
            switch (cmd) {
                case "Add":
                    int number = Integer.parseInt(command[1]);
                    numbers.add(number);
                    break;
                case "Remove":
                    int index = Integer.parseInt(command[1]);
                    if(index >= numbers.size() || index < 0){
                        System.out.println("Invalid index");
                    } else {
                        numbers.remove(index);
                    }
                    break;
                case "Shift":
                    String type = command[1];
                    int count = Integer.parseInt(command[2]);
                    shift(numbers, count, type);
                    break;
                case "Insert":
                    int atIndex = Integer.parseInt(command[2]);
                    int num = Integer.parseInt(command[1]);
                    if(atIndex >= numbers.size() || atIndex < 0){
                        System.out.println("Invalid index");
                    } else {
                        numbers.add(atIndex, num);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void shift(List<Integer> l, int n, String type){
        if(type.equals("left")) {
            for (int i = 0; i < n % l.size(); i++) {
                int firstNumber = l.get(0);
                l.add(firstNumber);
                l.remove(0);
            }
        } else {
            for (int i = 0; i < n % l.size(); i++) {
                int lastNumber = l.get(l.size() - 1);
                l.add(0, lastNumber);
                l.remove(l.size() -1);
            }
        }
    }
}
