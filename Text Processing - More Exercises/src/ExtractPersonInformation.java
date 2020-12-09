import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String data = scanner.nextLine();
            int startIndexOfName = data.indexOf("@") + 1;
            int endIndexOfName = data.indexOf("|");
            int startIndexOfAges = data.indexOf("#") + 1;
            int endIndexOfAges = data.indexOf("*");
            String name = data.substring(startIndexOfName, endIndexOfName);
            String years = data.substring(startIndexOfAges, endIndexOfAges);
            System.out.printf("%s is %s years old.%n", name, years);
        }
    }
}