import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger num1 = scanner.nextBigInteger();
        BigInteger num2 = scanner.nextBigInteger();
        BigInteger sum = num1.add(num2);
        System.out.println(sum);
    }
}
