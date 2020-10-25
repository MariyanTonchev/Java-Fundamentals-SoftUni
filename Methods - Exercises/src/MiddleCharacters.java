import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        printMidChar(string);
    }

    private static void printMidChar(String s) {
        int length = s.length();
        String output = "";
        if (length % 2 == 0) {
            char firstMid = s.charAt((length / 2) - 1);
            char secondMid = s.charAt(length / 2);
            output = Character.toString(firstMid) + secondMid;
        } else {
            char mid = s.charAt(length / 2);
            output = Character.toString(mid);
        }
        System.out.println(output);
    }
}
