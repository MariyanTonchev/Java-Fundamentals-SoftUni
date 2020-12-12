import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "(?<symbols>[\\D]*)(?<times>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            String symbols = matcher.group("symbols").toUpperCase();
            int times = Integer.parseInt(matcher.group("times"));
            for (int i = 0; i < times; i++) {
                sb.append(symbols);
            }
        }
        System.out.println("Unique symbols used: " + sb.chars().distinct().count());
        System.out.println(sb);
    }
}