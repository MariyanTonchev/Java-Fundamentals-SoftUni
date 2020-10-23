import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        if(n <= 0){
            System.out.println(0);
            return;
        }
        if(n == 1){
            System.out.println(1);
            return;
        }
        int[] array = new int[n];
        for (int i = 2; i <= n - 1; i++) {
            array[0] = 1;
            array[1] = 1;
            array[i] = array[i-1] + array[i-2];
        }
        System.out.println(array[array.length-1]);
    }
}
