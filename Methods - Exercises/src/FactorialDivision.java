import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long numOne = Integer.parseInt(scanner.nextLine());
        long numTwo = Integer.parseInt(scanner.nextLine());
        factorialDivision(numOne, numTwo);
    }

    private static double factorial(double n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    private static void factorialDivision(double n, double m) {
        Double result = factorial(n) / factorial(m);
        System.out.printf("%.2f", result);
    }
}
