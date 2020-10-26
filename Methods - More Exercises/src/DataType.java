import java.util.Scanner;

public class DataType {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        String value = scanner.nextLine();
        printFinalResult(type,value);
    }

    private static void printFinalResult(String t, String v) {
        switch (t) {
            case "int":
                int num = Integer.parseInt(v);
                System.out.println(num * 2);
                break;
            case "real":
                double real = Double.parseDouble(v);
                System.out.printf("%.2f",real * 1.5);
                break;
            case "string":
                System.out.println("$" + v + "$");
                break;
        }
    }
}
