import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int effEmpOne = Integer.parseInt(scanner.nextLine());
        int effEmpTwo = Integer.parseInt(scanner.nextLine());
        int effEmpThree = Integer.parseInt(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        int studentsPerHour = effEmpOne + effEmpTwo + effEmpThree;
        int hours = 0;
        while (studentsCount > 0){
            studentsCount -= studentsPerHour;
            if ((hours + 1) % 4 == 0){
                hours++;
            }
            hours++;
        }
        System.out.printf("Time needed: %dh.", hours);
    }
}
