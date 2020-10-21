import java.util.Arrays;
import java.util.Scanner;

public class EqualSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean isEqual = false;
        for (int i = 0; i < array.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = i - 1; j >= 0; j--) {
                leftSum += array[j];
            }
            for (int k = i + 1; k < array.length; k++) {
                rightSum += array[k];
            }
            if (leftSum == rightSum) {
                System.out.println(i);
                isEqual = true;
                break;
            }
        }
        if (!isEqual) {
            System.out.println("no");
        }
    }
}
