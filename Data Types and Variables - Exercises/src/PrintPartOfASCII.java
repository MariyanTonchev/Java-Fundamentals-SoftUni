import java.util.Scanner;

public class PrintPartOfASCII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        for(int i = start; i<= end; i++){
            System.out.printf("%c ", i);
        }
    }
}
