import java.util.Scanner;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] string = scanner.nextLine().split("\\|");
        String[] english = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
                "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
                "Y", "Z"};

        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        StringBuilder sb = new StringBuilder();
        for (String s : string) {
            String[] words = s.split(" ");
            sb.append(" ");
            for (String word : words) {
                for (int i = 0; i < morse.length; i++) {
                    if (morse[i].equals(word)) {
                        sb.append(english[i]);
                    }
                }
            }
        }
        String message = sb.substring(1, sb.length());
        System.out.println(message);
    }
}