import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string1 = scanner.next();
        String string2 = scanner.next();
        System.out.println(sumOfCharacters(string1, string2));
    }

    private static int sumOfCharacters(String string1, String string2) {
        int lenStringOne = string1.length();
        int lenStringTwo = string2.length();
        int sum = 0;
        for (int i = 0; i < Integer.min(lenStringOne, lenStringTwo); i++) {
            sum += string1.charAt(i) * string2.charAt(i);
        }
        if (lenStringOne < lenStringTwo) {
            for (int j = lenStringOne; j < lenStringTwo; j++) {
                sum += string2.charAt(j);
            }
        } else {
            for (int j = lenStringTwo; j < lenStringOne; j++) {
                sum += string1.charAt(j);
            }
        }
        return sum;
    }
}