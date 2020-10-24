import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operation = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        switch (operation){
            case "add":
                operationAdd(n,m);
                break;
            case "multiply":
                operationMultiply(n, m);
                break;
            case "subtract":
                operationSubtract(n,m);
                break;
            case "divide":
                operationDivide(n, m);
                break;
        }
    }

    public static void operationAdd(int n, int m) {
        System.out.println(n + m);
    }

    public static void operationMultiply(int n, int m) {
        System.out.println(n * m);
    }

    public static void operationSubtract(int n, int m) {
        System.out.println(n - m);
    }

    public static void operationDivide(int n, int m) {
        System.out.println(n / m);
    }
}
