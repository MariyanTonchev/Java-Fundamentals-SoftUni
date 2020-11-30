import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        LinkedHashMap<String, Integer> lettersCount = new LinkedHashMap<>();
        for (int i = 0; i < word.length(); i++) {
            String letter = String.valueOf(word.charAt(i));
            if (!letter.equals(" ")) {
                if (lettersCount.containsKey(letter)) {
                    lettersCount.put(letter, lettersCount.get(letter) + 1);
                } else {
                    lettersCount.put(letter, 1);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : lettersCount.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}