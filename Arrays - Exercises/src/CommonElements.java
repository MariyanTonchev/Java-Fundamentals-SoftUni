import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arrayOne = scanner.nextLine().split(" ");
        String[] arrayTwo = scanner.nextLine().split(" ");
        for (String value : arrayTwo) {
            for (int j = 0; j <= arrayOne.length - 1; j++) {
                String valueTwo = arrayOne[j];
                if (value.equals(valueTwo)) {
                    System.out.print(value + " ");
                }
            }
        }
    }
}
