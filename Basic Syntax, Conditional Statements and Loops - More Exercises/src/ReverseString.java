import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        for(int i=1; i<=string.length(); i++){
            System.out.print(string.charAt(string.length()-i));
        }
    }
}
