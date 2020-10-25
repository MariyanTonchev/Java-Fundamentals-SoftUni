import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOne = Integer.parseInt(scanner.nextLine());
        int numTwo = Integer.parseInt(scanner.nextLine());
        int numThree = Integer.parseInt(scanner.nextLine());
        System.out.println(subtract(numOne,numTwo,numThree));
    }

    private static Integer sum (int num1, int num2){
        return num1 + num2;
    }

    private static Integer subtract(int num1, int num2, int num3){
        return sum(num1,num2) - num3;
    }
}
