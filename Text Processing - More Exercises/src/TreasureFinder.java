import java.util.Arrays;
import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] key = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuilder sb = new StringBuilder();
        String input = scanner.nextLine();
        while (!"find".equals(input)) {
            int count = 0;
            for (int i = 0; i < input.length(); i++) {
                sb.append((char) (input.charAt(i) - key[count]));
                count++;
                if (count == key.length) {
                    count = 0;
                }
            }
            printMessage(sb);
            sb = new StringBuilder();
            input = scanner.nextLine();
        }
    }

    private static void printMessage(StringBuilder sb) {
        int startIndexOfType = sb.indexOf("&");
        int endIndexOfType = sb.lastIndexOf("&");
        String type = sb.substring(startIndexOfType + 1, endIndexOfType);
        int startIndexOfCoordinates = sb.indexOf("<");
        int endIndexOfCoordinates = sb.indexOf(">");
        String coordinates = sb.substring(startIndexOfCoordinates + 1, endIndexOfCoordinates);
        System.out.printf("Found %s at %s%n", type, coordinates);
    }
}