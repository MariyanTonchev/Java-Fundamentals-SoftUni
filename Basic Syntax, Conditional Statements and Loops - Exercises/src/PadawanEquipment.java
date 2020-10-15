import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double amountOfMoney = scanner.nextDouble();
        int students = scanner.nextInt();
        double priceOfLightSaber = scanner.nextDouble();
        double priceOfRobe = scanner.nextDouble();
        double priceOfBelt = scanner.nextDouble();
        double bonusLightSabers = Math.ceil(students * 0.10);
        double totalPriceForLightSabers = priceOfLightSaber * (students + bonusLightSabers);
        double totalPriceForRobes = priceOfRobe * students;
        int freeBelts = students / 6;
        double totalPriceForBelts = priceOfBelt * (students - freeBelts);
        double sum = totalPriceForBelts + totalPriceForLightSabers + totalPriceForRobes;
        if(amountOfMoney >= sum){
            System.out.printf("The money is enough - it would cost %.2flv.", sum);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.", Math.abs(amountOfMoney - sum));
        }
    }
}
