import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int groupOf = scanner.nextInt();
        String typeOf = scanner.next();
        String day = scanner.next();
        double singlePersonPrice = 0;
        switch (day){
            case "Friday":
                if(typeOf.equals("Students")){
                    singlePersonPrice = 8.45;
                } else if(typeOf.equals("Business")){
                    singlePersonPrice = 10.90;
                } else if(typeOf.equals("Regular")){
                    singlePersonPrice = 15;
                }
                break;
            case "Saturday":
                if(typeOf.equals("Students")){
                    singlePersonPrice = 9.80;
                } else if(typeOf.equals("Business")){
                    singlePersonPrice = 15.60;
                } else if(typeOf.equals("Regular")){
                    singlePersonPrice = 20;
                }
                break;
            case "Sunday":
                if(typeOf.equals("Students")){
                    singlePersonPrice = 10.46;
                } else if(typeOf.equals("Business")){
                    singlePersonPrice = 16;
                } else if(typeOf.equals("Regular")){
                    singlePersonPrice = 22.50;
                }
                break;
        }
        double totalPrice = groupOf * singlePersonPrice;
        if (typeOf.equals("Students") && groupOf >= 30){
            totalPrice = totalPrice - (totalPrice * 0.15);
        } else if (typeOf.equals("Business") && groupOf >= 100){
            totalPrice = totalPrice - (10 * singlePersonPrice);
        } else if (typeOf.equals("Regular") && (groupOf <= 20 && groupOf >= 10)){
            totalPrice = totalPrice - (totalPrice * 0.05);
        }
        System.out.printf("Total price: %.2f", totalPrice);
    }
}
