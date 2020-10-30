import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        String[] events = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};
        for (int i = 0; i < n; i++) {
            String phrase = random(phrases);
            String event = random(events);
            String author = random(authors);
            String city = random(cities);
            System.out.printf("%s %s %s - %s%n", phrase, event ,author, city);
        }
    }

    private static String random (String[] arr){
        Random random = new Random();
        int index = random.nextInt(arr.length);
        return arr[index];
    }
}
