import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printTopNumbers(n);
    }

    private static void printTopNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            if(isDivisibleByEight(i) && hasOddDigit(i)){
                System.out.println(i);
            }
        }
    }

    private static boolean hasOddDigit(int n){
        while (n > 0) {
            if((n % 10) % 2 == 1){
                return true;
            }
            n /= 10;
        }
        return false;
    }

    private static boolean isDivisibleByEight(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum % 8 == 0;
    }
}
