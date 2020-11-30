import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Integer> results = new HashMap<>();
        Map<String, Integer> submissions = new HashMap<>();
        while (!input.equals("exam finished")) {
            String[] data = input.split("-");
            String user = data[0];
            String language = data[1];
            if (data.length == 2) {
                results.remove(user);
            } else {
                int points = Integer.parseInt(data[2]);
                if (!results.containsKey(user)) {
                    results.putIfAbsent(user, points);
                }
                if (results.containsKey(user) && results.get(user) < points) {
                    results.put(user, points);
                }
                submissions.putIfAbsent(language, 0);
                submissions.put(language, submissions.get(language) + 1);
            }
            input = scanner.nextLine();
        }
        System.out.println("Results:");
        results.entrySet().stream().sorted((a, b) -> {
            int result = b.getValue().compareTo(a.getValue());
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(r -> {
            System.out.println(r.getKey() + " | " + r.getValue());
        });
        System.out.println("Submissions:");
        submissions.entrySet().stream().sorted((a, b) -> {
            int result = b.getValue().compareTo(a.getValue());
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(s -> {
            System.out.println(s.getKey() + " - " + s.getValue());
        });
    }
}