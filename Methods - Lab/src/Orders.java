import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        printTotalPrice(product, quantity);
    }

    public static void printTotalPrice(String p, int q) {
        switch (p) {
            case "coffee":
                System.out.printf("%.2f", 1.50 * q);
                break;
            case "water":
                System.out.printf("%.2f", 1.00 * q);
                break;
            case "coke":
                System.out.printf("%.2f", 1.40 * q);
                break;
            case "snacks":
                System.out.printf("%.2f", 2.00 * q);
                break;
        }
    }
}
