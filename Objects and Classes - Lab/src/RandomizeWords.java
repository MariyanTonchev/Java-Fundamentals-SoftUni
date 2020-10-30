import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        Random rnd = new Random();
        for (int p1 = 0; p1 < words.length; p1++){
            int p2 = rnd.nextInt(words.length);
            String temp = words[p1];
            words[p1] = words[p2];
            words[p2] = temp;
        }
        System.out.println(String.join(System.lineSeparator(),words));
    }
}
