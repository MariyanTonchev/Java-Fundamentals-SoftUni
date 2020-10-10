import java.util.Scanner;

public class StudentInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String studentName = scanner.nextLine();
        int studentAge = scanner.nextInt();
        double studentGrade = scanner.nextDouble();
        System.out.printf("Name: %s, Age: %d, Grade: %.2f", studentName, studentAge, studentGrade);
    }
}
