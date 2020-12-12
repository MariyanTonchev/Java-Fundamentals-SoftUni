import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tickets = scanner.nextLine().split("\\s*,\\s*");
        String regex = "(?=.{20}).*?(?=(?<a>[@#$^]))(?<match>\\k<a>{6,}).*(?<=.{10})\\k<match>.*";
        Pattern pattern = Pattern.compile(regex);
        for (String ticket : tickets) {
            if (ticket.length() != 20){
                System.out.println("invalid ticket");
            } else {
                Matcher matcher = pattern.matcher(ticket);
                if (matcher.matches()) {
                    String match = matcher.group("match");
                    System.out.printf("ticket \"%s\" - %d%s%s%n", ticket, match.length(), match.charAt(0), (match.length() == 10) ? " Jackpot!" : "");
                } else {
                    System.out.printf("ticket \"%s\" - no match%n", ticket);
                }
            }
        }
    }
}