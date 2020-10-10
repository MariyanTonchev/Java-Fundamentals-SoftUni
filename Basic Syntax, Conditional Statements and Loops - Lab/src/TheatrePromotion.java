import java.util.Scanner;

public class TheatrePromotion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String typeOfDay = scanner.nextLine();
        int age = scanner.nextInt();
        int price = 0;
        if(age <= 18 && age >= 0){
            switch (typeOfDay){
                case "Weekday":
                    price = 12;
                    break;
                case "Weekend":
                    price = 15;
                    break;
                case "Holiday":
                    price = 5;
                    break;
            }
        } else if (age <= 64 && age > 18){
            switch (typeOfDay){
                case "Weekday":
                    price = 18;
                    break;
                case "Weekend":
                    price = 20;
                    break;
                case "Holiday":
                    price = 12;
                    break;
            }
        } else if (age <= 122 && age > 64){
            switch (typeOfDay){
                case "Weekday":
                    price = 12;
                    break;
                case "Weekend":
                    price = 15;
                    break;
                case "Holiday":
                    price = 10;
                    break;
            }
        }

        if (price != 0) {
            System.out.println(price + "$");
        } else {
            System.out.println("Error!");
        }
    }
}
