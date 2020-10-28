import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int capacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("end")){
            String[] commands = input.split(" ");
            if(commands[0].equals("Add")){
                wagons.add(Integer.parseInt(commands[1]));
            } else {
                for (int i = 0; i < wagons.size(); i++) {
                    int passengers = Integer.parseInt(commands[0]);
                    if(wagons.get(i) + passengers <= capacity){
                        wagons.set(i, wagons.get(i) + passengers);
                        break;
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.println(wagons.toString().replaceAll("[\\[\\],]", ""));
    }
}
