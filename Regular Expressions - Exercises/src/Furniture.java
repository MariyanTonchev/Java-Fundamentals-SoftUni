import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "^>>(?<Name>[A-Za-z]+)<<(?<Price>\\d+\\.?\\d+)!(?<Quantity>\\d+)$";
        Pattern pattern = Pattern.compile(regex);
        List<String> furniture = new ArrayList<>();
        double totalCost = 0;
        while (!"Purchase".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group("Name");
                double price = Double.parseDouble(matcher.group("Price"));
                int quantity = Integer.parseInt(matcher.group("Quantity"));
                furniture.add(name);
                totalCost += price * quantity;
            }
            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        furniture.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", totalCost);
    }
}