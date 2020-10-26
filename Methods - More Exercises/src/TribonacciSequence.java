import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        printTribonacciSequence(n);
    }

    private static void printTribonacciSequence (int n){
        int[] array = new int[n];
        if(n==1) {
            array[0] = 1;
        } else if(n==2){
            array[0] = 1;
            array[1] = 1;
        } else {
            array[0] = 1;
            array[1] = 1;
            array[2] = 2;
        }
        for (int i=3; i<n; i++){
            array[i] = array[i-1] + array[i-2]+ array[i-3];
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
