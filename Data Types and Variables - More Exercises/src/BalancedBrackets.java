import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        boolean isBalanced = true;
        boolean isOpened = false;
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            if (input.equals("(")) {
                if (!isOpened) {
                    isOpened = true;
                } else {
                    isBalanced = false;
                }
            }
            if (input.equals(")")) {
                if (isOpened) {
                    isOpened = false;
                } else {
                    isBalanced = false;
                }
            }
        }
        if (isBalanced && !isOpened) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
