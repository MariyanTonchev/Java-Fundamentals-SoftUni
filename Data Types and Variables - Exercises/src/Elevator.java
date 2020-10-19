import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int persons = scanner.nextInt();
        int capacity = scanner.nextInt();
        int courses = (int) Math.ceil((double) persons/capacity);
        System.out.println(courses);
    }
}
