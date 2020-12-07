import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        for (String string : strings) {
            for (int j = 0; j < string.length(); j++) {
                System.out.print(string);
            }
        }
    }
}
