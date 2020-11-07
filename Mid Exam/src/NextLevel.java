import java.util.Scanner;

public class NextLevel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double reqExp = Double.parseDouble(scanner.nextLine());
        int battles = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= battles; i++) {
            double exp = Double.parseDouble(scanner.nextLine());
            if (i % 3 == 0) {
                exp += exp * 0.15;
            }
            if (i % 5 == 0) {
                exp -= exp * 0.10;
            }
            if (i % 15 == 0) {
                exp += exp * 0.05;
            }
            reqExp -= exp;
            if (reqExp <= 0) {
                System.out.printf("Player successfully collected his needed experience for %d battles.", i);
                break;
            }
        }
        if (reqExp > 0) {
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.", reqExp);
        }
    }
}
