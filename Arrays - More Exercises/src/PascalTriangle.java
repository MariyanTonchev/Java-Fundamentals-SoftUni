import java.util.Arrays;
import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        long[][] array = new long[rows][];
        array[0] = new long[1];
        array[0][0] = 1;
        for (int i = 1; i < array.length; i++) {
            array[i] = new long[i + 1];
            array[i][0] = 1;
            array[i][array[i].length - 1] = 1;
            for (int j = 1; j < array[i].length - 1; j++) {
                long leftSum = array[i - 1][j - 1];
                long rightSum = array[i - 1][j];
                array[i][j] = leftSum + rightSum;
            }
        }
        for (int i = 0; i < rows; i++) {
            long[] arr = array[i];
            for (long l : arr) {
                System.out.print(l + " ");
            }
            System.out.println();
        }
    }
}
