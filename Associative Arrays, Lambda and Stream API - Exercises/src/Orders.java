import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Double> productsPrice = new LinkedHashMap<>();
        Map<String, Integer> amountProducts = new LinkedHashMap<>();
        Map<String, Double> totalPrice = new LinkedHashMap<>();
        while (!input.equals("buy")) {
            String[] tokens = input.split(" ");
            String product = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            int amount = Integer.parseInt(tokens[2]);
            productsPrice.putIfAbsent(product, 0.0);
            amountProducts.putIfAbsent(product, 0);
            productsPrice.put(product, price);
            amountProducts.put(product, amountProducts.get(product) + amount);
            totalPrice.put(product, amountProducts.get(product) * productsPrice.get(product));
            input = scanner.nextLine();
        }
        totalPrice.forEach((key, value) -> System.out.printf("%s -> %.2f%n", key, value));
    }
}
