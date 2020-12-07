import java.util.Scanner;

public class DigitsLettersAndOthers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        StringBuilder letters = new StringBuilder();
        StringBuilder symbols = new StringBuilder();
        StringBuilder digits = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (Character.isDigit(character)) {
                digits.append(character);
            } else if (Character.isLetter(character)) {
                letters.append(character);
            } else {
                symbols.append(character);
            }
        }
        System.out.println(digits);
        System.out.println(letters);
        System.out.println(symbols);
    }
}