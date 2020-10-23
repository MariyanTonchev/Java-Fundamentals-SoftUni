import java.util.Scanner;

public class EncryptSortPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStrings = Integer.parseInt(scanner.nextLine());
        int[] encryptedStrings = new int[numberOfStrings];
        for (int i = 0; i < encryptedStrings.length; i++) {
            String string = scanner.nextLine();
            int stringLength = string.length();
            int sumOfVowels = 0;
            int sumOfConsonants = 0;
            for (int j = 0; j < stringLength; j++) {
                char charOfString = string.charAt(j);
                if (charOfString == 'a' || charOfString == 'A' || charOfString == 'e' || charOfString == 'E' || charOfString == 'i' || charOfString == 'I' || charOfString == 'o' || charOfString == 'O' || charOfString == 'u' || charOfString == 'U') {
                    sumOfVowels += (int) charOfString * stringLength;
                } else {
                    sumOfConsonants += (int) charOfString / stringLength;
                }
            }
            int encryptedString = sumOfConsonants + sumOfVowels;
            encryptedStrings[i] = encryptedString;
        }
        for (int i = 0; i <= encryptedStrings.length - 1; i++) {
            for (int j = 0; j < encryptedStrings.length - 1; j++) {
                if (encryptedStrings[j + 1] < encryptedStrings[j]) {
                    int temp = encryptedStrings[j];
                    encryptedStrings[j] = encryptedStrings[j + 1];
                    encryptedStrings[j + 1] = temp;
                }
            }
        }
        for (int encryptedString : encryptedStrings) {
            System.out.println(encryptedString);
        }
    }
}
