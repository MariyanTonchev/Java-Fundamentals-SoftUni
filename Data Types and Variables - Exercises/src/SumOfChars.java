import java.util.Scanner;

public class SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for(int i = 1; i <= n; i++){
            char m = scanner.nextLine().charAt(0);
            sum += m;
        }
        System.out.printf("The sum is equals: %d", sum);
    }
}
