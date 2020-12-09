import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstChar = scanner.nextLine().charAt(0);
        int secondChar = scanner.nextLine().charAt(0);
        String string = scanner.nextLine();
        int sum = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) > firstChar && string.charAt(i) < secondChar) {
                sum += string.charAt(i);
            }
        }
        System.out.println(sum);
    }
}