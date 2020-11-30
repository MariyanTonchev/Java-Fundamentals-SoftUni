import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, ArrayList<String>> courses = new LinkedHashMap<>();
        while (!input.equals("end")) {
            String[] data = input.split(" : ");
            String courseName = data[0];
            String student = data[1];
            if (!courses.containsKey(courseName)) {
                courses.put(data[0], new ArrayList<>());
            }
            courses.get(courseName).add(student);
            input = scanner.nextLine();
        }

        courses.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().size() - a.getValue().size())
                .forEach(e -> {
                    System.out.println(e.getKey() + ": " + e.getValue().size());
                    e.getValue()
                            .stream().sorted(String::compareTo)
                            .forEach(s -> System.out.println("-- " + s));
                });
    }
}