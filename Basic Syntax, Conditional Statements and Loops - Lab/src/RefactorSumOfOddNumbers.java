import java.util.Scanner;

public class RefactorSumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        int j = 1;
        for(int i=1; i <= n; i++){
            if(j%2==1){
                System.out.println(j);
                sum += j;
            }
            j += 2;
        }
        System.out.printf("Sum: %d", sum);
    }
}
