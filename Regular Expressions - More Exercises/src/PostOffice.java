import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\|");
        String firstPart = input[0];
        String secondPart = input[1];
        String thirdPart = input[2];
        String firstRegex = "([#$%*&])(?<letters>[A-Z]+)(\\1)";
        Pattern firstPattern = Pattern.compile(firstRegex);
        Matcher firstMatcher = firstPattern.matcher(firstPart);
        if (firstMatcher.find()) {
            String capitals = firstMatcher.group("letters");
            for (int i = 0; i < capitals.length(); i++) {
                int startLetter = capitals.charAt(i);
                String secondRegex = "(" + startLetter + ")+:(?<length>[0-9][0-9])";
                Pattern secondPattern = Pattern.compile(secondRegex);
                Matcher secondMatcher = secondPattern.matcher(secondPart);
                if (secondMatcher.find()) {
                    int len = Integer.parseInt(secondMatcher.group("length"));
                    String thirdRegex = "(?<=\\s|^)[" + capitals.charAt(i) + "][^\\s]{" + len + "}(?=\\s|$)";
                    Pattern thirdPattern = Pattern.compile(thirdRegex);
                    Matcher matcher = thirdPattern.matcher(thirdPart);
                    while (matcher.find()) {
                        System.out.println(matcher.group());
                    }
                }
            }
        }
    }
}