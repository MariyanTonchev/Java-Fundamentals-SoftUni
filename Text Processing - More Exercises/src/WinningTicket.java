import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        String[] ticket = input.split("[, ]+");
        for (String value : ticket) {
            if (value.length() == 20) {
                String left = value.substring(0, 10);
                String right = value.substring(10, 20);
                String leftMach = "a";
                String rightMach = "s";
                Pattern pattern = Pattern.compile("[\\\\@]{6,}|[\\\\$]{6,}|[\\\\#]{6,}|[\\\\^]{6,}");
                Matcher lm = pattern.matcher(left);
                Matcher rm = pattern.matcher(right);
                if (lm.find()) {
                    leftMach = lm.group();
                }
                if (rm.find()) {
                    rightMach = rm.group();
                }
                if (leftMach.substring(0, 1).equals(rightMach.substring(0, 1))) {
                    int matchCount = Math.min(leftMach.length(), rightMach.length());
                    if (matchCount == 10) {
                        System.out.printf("ticket \"%s\" - %d%s Jackpot!%n", value, matchCount, leftMach.charAt(0));
                    } else {
                        System.out.printf("ticket \"%s\" - %d%s%n", value, matchCount, leftMach.charAt(0));
                    }
                } else {
                    System.out.printf("ticket \"%s\" - no match%n", value);
                }
            } else {
                System.out.println("invalid ticket");
            }
        }
    }
}