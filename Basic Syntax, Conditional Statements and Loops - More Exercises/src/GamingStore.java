import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double money = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        double price = 0;
        double totalSpent = 0;
        while (!input.equals("Game Time")){
            switch (input){
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    gameCheck(price, money, input);
                    break;
                case "CS: OG":
                    price = 15.99;
                    gameCheck(price, money, input);
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    gameCheck(price, money, input);
                    break;
                case "Honored 2":
                    price = 59.99;
                    gameCheck(price, money, input);
                    break;
                case "RoverWatch":
                    price = 29.99;
                    gameCheck(price, money, input);
                    break;
                default:
                    System.out.println("Not Found");
                    break;
            }
            if (price <= money){
                money -= price;
                totalSpent += price;
            }
            input = scanner.nextLine();
        }
        if(money > 0){
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSpent, money);
        } else {
            System.out.println("Out of mo-ney!");
        }
    }

    static void gameCheck(double price, double money, String input){
        if (price <= money){
            System.out.printf("Bought %s%n", input);
        } else {
            System.out.println("Too Expensive");
        }
    }
}
