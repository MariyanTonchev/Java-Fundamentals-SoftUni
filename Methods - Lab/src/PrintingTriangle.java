import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            printRow(1, i);
        }
        printRow(1, n);
        for (int i = n - 1; i >= 1; i--){
            printRow(1, i);
        }
    }

    public static void printRow(int s, int e){
        for (int i = s; i <= e; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

