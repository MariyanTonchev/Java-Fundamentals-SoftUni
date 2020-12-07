import java.util.Scanner;

public class SubStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String key = scanner.nextLine();
        String word = scanner.nextLine();
        while (word.contains(key)) {
            word = word.replace(key, "");
        }
        System.out.println(word);
    }
}