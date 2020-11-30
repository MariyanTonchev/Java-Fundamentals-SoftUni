import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LargestThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> sorted = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        if (sorted.size() < 3) {
            for (Integer i : sorted) {
                System.out.print(i + " ");
            }
        } else {
            for (int i = 0; i < 3; i++) {
                System.out.print(sorted.get(i) + " ");
            }
        }
    }
}
