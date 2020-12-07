import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(scanner.nextLine());
        int str = 0;
        for (int i = 0; i < sb.length(); i++) {
            char current = sb.charAt(i);
            if(current == '>'){
                str += Character.getNumericValue(sb.charAt(i + 1));
            } else if (str > 0 && sb.charAt(i) != '>'){
                sb.deleteCharAt(i);
                str--;
                i--;
            }
        }
        System.out.println(sb);
    }
}