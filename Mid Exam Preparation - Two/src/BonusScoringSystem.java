import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = Integer.parseInt(scanner.nextLine());
        int lectures = Integer.parseInt(scanner.nextLine());
        int bonus = Integer.parseInt(scanner.nextLine());
        double maxBonus = Double.MIN_VALUE;
        int attendedLectures = 0;
        for (int i = 0; i < students; i++) {
            int attendance = Integer.parseInt(scanner.nextLine());
            double totalBonus = attendance * 1.0 / lectures * (5 + bonus);
            if(totalBonus > maxBonus){
                maxBonus = totalBonus;
                attendedLectures = attendance;
            }
        }
        System.out.printf("Max Bonus: %.0f.%nThe student has attended %d lectures.", maxBonus, attendedLectures);
    }
}
