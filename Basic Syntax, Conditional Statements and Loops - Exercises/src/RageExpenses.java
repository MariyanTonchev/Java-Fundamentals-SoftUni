import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lostGamesCount = scanner.nextInt();
        double headsetPrice = scanner.nextDouble();
        double mousePrice = scanner.nextDouble();
        double keyboardPrice = scanner.nextDouble();
        double displayPrice = scanner.nextDouble();
        int trashedHeadset = lostGamesCount / 2;
        int trashedMouse = lostGamesCount / 3;
        int trashedKeyboard = lostGamesCount / 6;
        int trashedDisplay = lostGamesCount / 12;
        double sum = trashedHeadset * headsetPrice + trashedMouse * mousePrice + keyboardPrice * trashedKeyboard + displayPrice * trashedDisplay;
        System.out.printf("Rage expenses: %.2f lv.", sum);
    }
}
