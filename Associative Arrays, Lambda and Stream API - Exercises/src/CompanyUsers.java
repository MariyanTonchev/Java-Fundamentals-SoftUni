import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> companies = new LinkedHashMap<>();
        while (!input.equals("End")) {
            String[] data = input.split(" -> ");
            String company = data[0];
            String employee = data[1];
            companies.putIfAbsent(company, new ArrayList<>());
            if (!companies.get(company).contains(employee)) {
                companies.get(company).add(employee);
            }
            input = scanner.nextLine();
        }
        companies.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(c -> {
            System.out.println(c.getKey());
            c.getValue().forEach(s -> System.out.println("-- " + s));
        });
    }
}