import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        printNumberOfVowels(string);
    }

    private  static void printNumberOfVowels(String s){
        String lowerCase = s.toLowerCase();
        int count = 0;
        for (int i = 0; i < lowerCase.length(); i++) {
            char letter = lowerCase.charAt(i);
            if(letter == 'a' || letter == 'i' || letter == 'e' || letter == 'o' || letter == 'u'){
                count++;
            }
        }
        System.out.println(count);
    }
}
