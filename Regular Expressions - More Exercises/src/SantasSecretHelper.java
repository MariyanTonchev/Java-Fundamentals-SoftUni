import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantasSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        String regex = "@(?<name>[A-Za-z]+)[^@\\-!:>]+!(?<behavior>[GN])!";
        Pattern pattern = Pattern.compile(regex);
        while (!input.equals("end")) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                sb.append((char) (input.charAt(i) - key));
            }
            Matcher matcher = pattern.matcher(sb.toString());
            if (matcher.find()) {
                String name = matcher.group("name");
                String behavior = matcher.group("behavior");
                if (behavior.equals("G")) {
                    System.out.println(name);
                }
            }
            input = scanner.nextLine();
        }
    }
}