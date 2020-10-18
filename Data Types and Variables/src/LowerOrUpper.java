import java.util.Scanner;

public class LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char n = scanner.nextLine().charAt(0);
        if(n >= 65 && n <= 90){
            System.out.println("upper-case");
        } else if(n >= 92 && n <= 122){
            System.out.println("lower-case");
        }
    }
}
