import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        validatePassword(password);
    }

    private static boolean checkLength(String pass){
        return pass.length() >= 6 && pass.length() <= 10;
    }

    private static boolean checkCharacters(String pass){
        String lowerCasePass = pass.toLowerCase();
        for (int i = 0; i < pass.length(); i++) {
            char c = lowerCasePass.charAt(i);
            if(!((c >= 97 && c <= 122) || (c >= 48 && c <= 57))){
                return false;
            }
        }
        return true;
    }

    private static boolean checkDigits(String pass){
        int count = 0;
        for (int i = 0; i < pass.length(); i++) {
            char c = pass.charAt(i);
            if(c >= 48 && c <= 57){
                count++;
            }
        }
        return count >= 2;
    }

    private static void validatePassword(String pass){
        if(!checkLength(pass)){
            System.out.println("Password must be between 6 and 10 characters");
        }
        if(!checkCharacters(pass)){
            System.out.println("Password must consist only of letters and digits");
        }
        if(!checkDigits(pass)){
            System.out.println("Password must have at least 2 digits");
        }
        if(checkDigits(pass) && checkCharacters(pass) && checkLength(pass)){
            System.out.println("Password is valid");
        }
    }
}
