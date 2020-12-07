import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        for(char c : string.toCharArray()){
            System.out.print((char)(c + 3));
        }
    }
}
