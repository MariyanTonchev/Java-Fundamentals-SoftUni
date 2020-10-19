import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder message = new StringBuilder();
        for(int i=0; i<n; i++){
            char m = scanner.nextLine().charAt(0);
            int value = m + key;
            char finalChar = (char) value;
            message.append(finalChar);
        }
        System.out.println(message);
    }
}
