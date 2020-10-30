import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Person> people = new ArrayList<>();
        while (!input.equals("End")) {
            String[] data = input.split(" ");
            Person person = new Person(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));
            people.add(person);
            input = scanner.nextLine();
        }
        people.stream().sorted(Comparator.comparing(Person::getAge)).forEach(System.out::println);
    }

    private static class Person {
        String name;
        int id;
        int age;

        public Person(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        @Override
        public String toString() {
            return String.format("%s with ID: %d is %d years old.", name, id, age);
        }

        public int getAge() {
            return age;
        }
    }
}
