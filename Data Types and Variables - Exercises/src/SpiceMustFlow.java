import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startingYield = scanner.nextInt();
        int storage = 0;
        int days = 0;
        while (startingYield >= 100){
            storage += startingYield;
            if (storage >= 26) {
                storage -= 26;
            }
            startingYield -= 10;
            days++;
        }
        if (storage >= 26) {
            storage -= 26;
        }
        System.out.printf("%d%n%d",days,storage);
    }
}
