import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listOne = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> listTwo = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        printList(mergeLists(listOne, listTwo));
    }

    private static List<Integer> mergeLists(List<Integer> listOne, List<Integer> listTwo) {
        List<Integer> mergedList = new ArrayList<>();
        if (listOne.size() >= listTwo.size()) {
            for (int i = 0; i < listOne.size(); i++) {
                mergedList.add(listOne.get(i));
                if (i < listTwo.size()) {
                    mergedList.add(listTwo.get(i));
                }
            }
        } else {
            for (int i = 0; i < listTwo.size(); i++) {
                if (i < listOne.size()) {
                    mergedList.add(listOne.get(i));
                }
                mergedList.add(listTwo.get(i));
            }
        }
        return mergedList;
    }

    private static void printList(List<Integer> numbers) {
        StringBuilder output = new StringBuilder();
        for (Integer number : numbers) {
            output.append(number).append(" ");
        }
        System.out.println(output.toString());
    }
}
