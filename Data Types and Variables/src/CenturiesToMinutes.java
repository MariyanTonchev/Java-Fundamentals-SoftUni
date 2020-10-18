import java.util.Scanner;

public class CenturiesToMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int centuries = scanner.nextInt();
        int inYears = centuries * 100;
        int inDays = (int) (inYears * 365.2422);
        int inHours = inDays * 24;
        int inMinutes = inHours * 60;
        System.out.printf("%d centuries = %d years = %d days = %d hours = %d minutes", centuries, inYears, inDays, inHours, inMinutes);
    }
}
