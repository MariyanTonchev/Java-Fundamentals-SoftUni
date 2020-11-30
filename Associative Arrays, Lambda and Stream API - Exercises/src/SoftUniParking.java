import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> registeredUsers = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String cmd = tokens[0];
            String username = tokens[1];
            if (cmd.equals("register")) {
                String licensePlateNumber = tokens[2];
                if (registeredUsers.containsKey(username)) {
                    System.out.printf("ERROR: already registered with plate number %s%n", registeredUsers.get(username));
                } else {
                    registeredUsers.put(username, licensePlateNumber);
                    System.out.printf("%s registered %s successfully%n", username, licensePlateNumber);
                }
            } else {
                if (!registeredUsers.containsKey(username)) {
                    System.out.printf("ERROR: user %s not found%n", username);
                } else {
                    registeredUsers.remove(username);
                    System.out.printf("%s unregistered successfully%n", username);
                }
            }
        }
        registeredUsers.forEach((key, value) -> System.out.printf("%s => %s%n", key, value));
    }
}