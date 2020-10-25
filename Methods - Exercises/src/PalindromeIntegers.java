import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("END")){
            isPalindrome(Integer.parseInt(input));
            input = scanner.nextLine();
        }
    }

    private static void isPalindrome(int n){
        if (n == reverseNumber(n)){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    private static int reverseNumber(int n){
        StringBuilder reversedNumber = new StringBuilder();
        while (n != 0){
            int digit = n % 10;
            reversedNumber.append(digit);
            n /= 10;
        }
        return Integer.parseInt(reversedNumber.toString());
    }
}
