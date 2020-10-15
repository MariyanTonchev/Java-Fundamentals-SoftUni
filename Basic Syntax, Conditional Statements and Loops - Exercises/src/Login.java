import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String inputPass = scanner.next();
        byte[] stringAsByteArray = input.getBytes();
        byte[] result = new byte[stringAsByteArray.length];
        for (int i = 0; i < stringAsByteArray.length; i++){
            result[i] =stringAsByteArray[stringAsByteArray.length - i - 1];
        }
        String password = new String(result);
        int k = 0;
        while (!inputPass.equals(password)){
            if(k >= 3){
                System.out.printf("User %s blocked!", input);
                break;
            } else {
                k++;
                System.out.println("Incorrect password. Try again.");
                inputPass = scanner.next();
            }
        }
        if (inputPass.equals(password)){
            System.out.printf("User %s logged in.", input);
        }
    }
}
