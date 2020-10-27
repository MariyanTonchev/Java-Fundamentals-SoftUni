import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listOfIntegers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("end")){
            String[] inputs = input.split(" ");
            int index = 0;
            try {
                index = Integer.parseInt(inputs[1]);
            } catch (NumberFormatException ignored){

            }
            switch (inputs[0]){
                case "Add":
                    listOfIntegers.add(index);
                    break;
                case "Remove":
                    listOfIntegers.remove(Integer.valueOf(index));
                    break;
                case "RemoveAt":
                    listOfIntegers.remove(index);
                    break;
                case "Insert":
                    int insertIndex = Integer.parseInt(inputs[2]);
                    listOfIntegers.add(insertIndex, index);
                    break;
                case "Contains":
                    contains(listOfIntegers, index);
                    break;
                case "Print":
                    String type = String.valueOf(inputs[1]);
                    printEvenOrOdd(listOfIntegers, type);
                    break;
                case "Get":
                    printSum(listOfIntegers);
                    break;
                case "Filter":
                    String operator = String.valueOf(inputs[1]);
                    int value = Integer.parseInt(inputs[2]);
                    filter(listOfIntegers, operator, value);
                    break;
            }
            input = scanner.nextLine();
        }
    }

    private static void contains(List<Integer> list, int n){
        if(list.contains(n)){
            System.out.println("Yes");
        } else {
            System.out.println("No such number");
        }
    }

    private static void printEvenOrOdd(List<Integer> list, String type){
        if(type.equals("even")){
            for (Integer integer : list) {
                if (integer % 2 == 0) {
                    System.out.print(integer + " ");
                }
            }
        } else {
            for (Integer integer : list) {
                if (integer % 2 == 1) {
                    System.out.print(integer + " ");
                }
            }
        }
        System.out.println();
    }

    private static void filter(List<Integer> list,String operator, int number){
        switch (operator) {
            case ">=":
                for (Integer integer : list) {
                    if (integer >= number)
                        System.out.print(integer + " ");
                }
                System.out.println();
                break;
            case ">":
                for (Integer integer : list) {
                    if (integer > number)
                        System.out.print(integer + " ");
                }
                System.out.println();
                break;
            case "<=":
                for (Integer integer : list) {
                    if (integer <= number)
                        System.out.print(integer + " ");
                }
                System.out.println();
                break;
            default:
                for (Integer integer : list) {
                    if (integer < number)
                        System.out.print(integer + " ");
                }
                System.out.println();
                break;
        }
    }

    private static void printSum(List<Integer> list){
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        System.out.println(sum);
    }
}
