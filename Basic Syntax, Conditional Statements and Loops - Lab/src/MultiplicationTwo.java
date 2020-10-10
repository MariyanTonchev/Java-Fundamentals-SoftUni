import java.util.Scanner;

public class MultiplicationTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        if(k > 10){
            System.out.printf("%d X %d = %d", n, k, n*k);
        } else {
            for (int i = k; i <= 10; i++) {
                System.out.printf("%d X %d = %d%n", n, i, i*n);
            }
        }
    }
}
