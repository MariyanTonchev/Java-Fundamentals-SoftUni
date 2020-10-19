import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double numOne = Double.parseDouble(scanner.nextLine());
        double numTwo = Double.parseDouble(scanner.nextLine());
        double eps = 0.000001;
        if(numOne < numTwo){
            double temp = numOne;
            numOne = numTwo;
            numTwo = temp;
        }
        double diff = numOne - numTwo;
        if (diff > eps){
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }
}
