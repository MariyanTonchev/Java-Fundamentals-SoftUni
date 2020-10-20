import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
        int sumOfOdd = 0;
        int sumOfEven = 0;
        for (int j : array) {
            if (j % 2 == 0) {
                sumOfEven += j;
            } else {
                sumOfOdd += j;
            }
        }
        System.out.println(sumOfEven - sumOfOdd);
    }
}
