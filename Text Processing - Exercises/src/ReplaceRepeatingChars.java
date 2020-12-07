import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        char prevChar = string.charAt(0);
        sb.append(prevChar);
        for (int i = 1; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            if(prevChar != currentChar){
                sb.append(currentChar);
                prevChar = currentChar;
            }
        }
        System.out.println(sb);
    }
}