import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentsVersionTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Student> students = new ArrayList<>();
        while (!input.equals("end")) {
            String[] data = input.split(" ");
            String firstName = data[0];
            String lastName = data[1];
            int age = Integer.parseInt(data[2]);
            String homeTown = data[3];
            if(isExisting(students,firstName,lastName)){
                Student student = getStudent(students,firstName,lastName);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setAge(age);
                student.setHomeTown(homeTown);
            } else {
                Student student = new Student(firstName, lastName, age, homeTown);
                students.add(student);
            }
            input = scanner.nextLine();
        }
        String cityName = scanner.nextLine();
        for (Student student : students) {
            if (student.getHomeTown().equals(cityName)) {
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }

    private static Student getStudent(List<Student> students, String firstName, String lastName) {
        Student existing = null;
        for (Student student : students){
            if(student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
                existing = student;
            }
        }
        return existing;
    }

    private static boolean isExisting(List<Student> students, String firstName, String lastName){
        for (Student student : students){
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
                return true;
            }
        }
        return false;
    }

    private static class Student {
        String firstName;
        String lastName;
        int age;
        String homeTown;

        public Student(String firstName, String lastName, int age, String homeTown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.homeTown = homeTown;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getHomeTown() {
            return homeTown;
        }

        public void setHomeTown(String homeTown) {
            this.homeTown = homeTown;
        }
    }
}
