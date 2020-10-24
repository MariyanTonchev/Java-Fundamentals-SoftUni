import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());
        String newString = repeatString(string, n);
        System.out.println(newString);
    }

    private static String repeatString(String s, int n){
        String string = "";
        for (int i = 0; i < n; i++) {
            string += s;
        }
        return string;
    }
}
