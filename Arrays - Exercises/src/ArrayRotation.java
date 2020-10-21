import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int numRotations = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numRotations; i++) {
            int firstElement = array[0];
            System.arraycopy(array, 1, array, 0, array.length - 1);
            array[array.length - 1] = firstElement;
        }
        for (int j : array) {
            System.out.print(j + " ");
        }
    }
}
