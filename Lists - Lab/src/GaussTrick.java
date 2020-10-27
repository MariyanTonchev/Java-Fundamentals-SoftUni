import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        for (int i = 0; i < numbers.size() - 1; i++) {
            numbers.set(i, numbers.get(i) + numbers.get(numbers.size() - 1));
            numbers.remove(numbers.size()-1);
        }
        System.out.println(getList(numbers));
    }
    private static String getList(List<Integer> numbers) {
        StringBuilder output = new StringBuilder();
        for (Integer number : numbers) {
            output.append(number).append(" ");
        }
        return output.toString();
    }
}
