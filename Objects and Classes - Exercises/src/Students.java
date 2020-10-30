import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Students {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] data = scanner.nextLine().split(" ");
            Student student = new Student(data[0], data[1], Double.parseDouble(data[2]));
            students.add(student);
        }
        students.stream().sorted(Comparator.comparing(Student::getGrade).reversed()).forEach(System.out::println);
    }

    private static class Student{
        String firstName;
        String lastName;
        double grade;

        public Student(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public double getGrade() {
            return grade;
        }

        @Override
        public String toString() {
            return String.format("%s %s: %.2f", firstName, lastName, grade);
        }
    }
}
