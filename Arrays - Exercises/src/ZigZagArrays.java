import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arrayOne = new int[n];
        int[] arrayTwo = new int[n];
        boolean firstArray = true;
        for (int i = 0; i < n; i++) {
            int numOne = scanner.nextInt();
            int numTwo = scanner.nextInt();
            if (firstArray) {
                arrayOne[i] = numOne;
                arrayTwo[i] = numTwo;
                firstArray = false;
            } else {
                arrayOne[i] = numTwo;
                arrayTwo[i] = numOne;
                firstArray = true;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arrayOne[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(arrayTwo[i] + " ");
        }
    }
}
