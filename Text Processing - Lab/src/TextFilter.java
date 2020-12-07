import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();
        for (String banWord : bannedWords) {
            int replacementLength = banWord.length();
            StringBuilder replacement = new StringBuilder();
            for (int j = 0; j < replacementLength; j++) {
                replacement.append("*");
            }
            text = text.replace(banWord, replacement);
        }
        System.out.println(text);
    }
}
