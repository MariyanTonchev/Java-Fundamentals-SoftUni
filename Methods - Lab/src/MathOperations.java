import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double numOne = Double.parseDouble(scanner.nextLine());
        String operator = scanner.nextLine();
        double numTwo = Double.parseDouble(scanner.nextLine());
        System.out.println(new DecimalFormat("0.##").format(calculate(numOne,operator,numTwo)));
    }

    private static double calculate(double n, String s, double m){
        double result = 0;
        switch (s){
            case "+":
                result = n + m;
                break;
            case "-":
                result = n - m;
                break;
            case "*":
                result = n * m;
                break;
            case "/":
                result = n / m;
                break;
        }
        return result;
    }
}
