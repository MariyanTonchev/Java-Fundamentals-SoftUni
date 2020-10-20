import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arrayOne = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arrayTwo = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int maxLength = Math.max(arrayOne.length, arrayTwo.length);
        int sum = 0;
        boolean isIdentical = true;
        for (int i = 0; i < maxLength; i++) {
            sum += arrayOne[i];
            if(arrayOne[i] != arrayTwo[i]){
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                isIdentical = false;
                break;
            }
        }
        if(isIdentical) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}
