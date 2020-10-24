import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        if (type.equals("int")) {
            int inputOne = Integer.parseInt(scanner.nextLine());
            int inputTwo = Integer.parseInt(scanner.nextLine());
            System.out.println(getMax(inputOne,inputTwo));
        } else if (type.equals("char")) {
            char inputOne = scanner.nextLine().charAt(0);
            char inputTwo = scanner.nextLine().charAt(0);
            System.out.println(getMax(inputOne,inputTwo));
        } else {
            String inputOne = scanner.nextLine();
            String inputTwo = scanner.nextLine();
            System.out.println(getMax(inputOne,inputTwo));
        }

    }

    private static String getMax(String s1, String s2) {
        if (s1.compareTo(s2) >= 0) {
            return s1;
        }
        return s2;
    }

    private static char getMax(char c1, char c2) {
        if (c1 > c2) {
            return c1;
        }
        return c2;
    }

    private static int getMax(int n1, int n2) {
        return Math.max(n1, n2);
    }
}
