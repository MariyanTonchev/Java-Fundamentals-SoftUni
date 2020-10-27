import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listOfIntegers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("end")){
            String[] inputs = input.split(" ");
            int index = Integer.parseInt(inputs[1]);
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
            }
            input = scanner.nextLine();
        }
        printList(listOfIntegers);
    }

    private static void printList(List<Integer> list){
        StringBuilder output = new StringBuilder();
        for (Integer integer : list) {
            output.append(integer).append(" ");
        }
        System.out.println(output);
    }
}
