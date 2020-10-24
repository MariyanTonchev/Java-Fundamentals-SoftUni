import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(sum(n));
    }

    private static int sum(int n) {
        int sumEven = 0;
        int sumOdd = 0;
        while (n != 0 ) {
            int lastDigit = n % 10;
            if (lastDigit % 2 == 0) {
                sumEven += lastDigit;
            } else {
                sumOdd += lastDigit;
            }
            n /= 10;
        }
        return sumEven * sumOdd;
    }
}
