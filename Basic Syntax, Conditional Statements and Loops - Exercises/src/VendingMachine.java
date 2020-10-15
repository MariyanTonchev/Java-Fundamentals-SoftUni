import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double totalInserted = 0;
        while (!input.equals("Start")){
            double insertedCoins = Double.parseDouble(input);
            if(insertedCoins == 0.1 || insertedCoins == 0.2 || insertedCoins == 0.5 || insertedCoins == 1 || insertedCoins == 2){
                totalInserted += insertedCoins;
            } else {
                System.out.printf("Cannot accept %.2f%n", insertedCoins);
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("End")){
            switch (input){
                case "Nuts":
                    if(totalInserted >= 2.0){
                        System.out.println("Purchased Nuts");
                        totalInserted -= 2.0;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Water":
                    if(totalInserted >= 0.7){
                        System.out.println("Purchased Water");
                        totalInserted -= 0.7;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Crisps":
                    if(totalInserted >= 1.5){
                        System.out.println("Purchased Crisps");
                        totalInserted -= 1.5;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Soda":
                    if(totalInserted >= 0.8){
                        System.out.println("Purchased Soda");
                        totalInserted -= 0.8;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Coke":
                    if(totalInserted >= 1.0){
                        System.out.println("Purchased Coke");
                        totalInserted -= 1.0;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", totalInserted);
    }
}
