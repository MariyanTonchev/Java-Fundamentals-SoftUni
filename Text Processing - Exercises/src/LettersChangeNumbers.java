import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        double sum = 0;
        for (String string : strings) {
            char firstLetter = string.charAt(0);
            char secondLetter = string.charAt(string.length() - 1);
            StringBuilder num = new StringBuilder();
            for (int j = 0; j < string.length(); j++) {
                char symbol = string.charAt(j);
                if (Character.isDigit(symbol)) {
                    num.append(symbol);
                }
            }
            double number = Double.parseDouble(String.valueOf(num));
            int fl = getLetterInAlphabeticPos(firstLetter);
            int sl = getLetterInAlphabeticPos(secondLetter);
            if (Character.isUpperCase(firstLetter)) {
                sum += number / fl;
            } else {
                sum += number * fl;
            }
            if (Character.isUpperCase(secondLetter)) {
                sum -= sl;
            } else {
                sum += sl;
            }
        }
        System.out.printf("%.2f", sum);
    }

    private static int getLetterInAlphabeticPos(char c) {
        return Character.toLowerCase(c) - 96;
    }
}