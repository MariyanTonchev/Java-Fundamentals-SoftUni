import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String regex = "(?i)[star]";
        Pattern pattern = Pattern.compile(regex);
        String secondRegex = "@(?<planet>[A-Za-z]+)[^@\\-!:>]*:(?<population>\\d+)[^@\\-!:>]*!(?<type>[A|D])![^@\\-!:>]*->(?<power>\\d+)";
        Pattern secondPattern = Pattern.compile(secondRegex);
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            int count = 0;
            while (matcher.find()) {
                count++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < input.length(); j++) {
                sb.append((char) (input.charAt(j) - count));
            }
            Matcher secondMatcher = secondPattern.matcher(sb.toString());
            while (secondMatcher.find()) {
                String name = secondMatcher.group("planet");
                String type = secondMatcher.group("type");
                if (type.equals("D")) {
                    destroyedPlanets.add(name);
                } else {
                    attackedPlanets.add(name);
                }
            }
        }
        System.out.println("Attacked planets: " + attackedPlanets.size());
        attackedPlanets.stream().sorted(String::compareTo).forEach(s -> {
            System.out.println("-> " + s);
        });
        System.out.println("Destroyed planets: " + destroyedPlanets.size());
        destroyedPlanets.stream().sorted(String::compareTo).forEach(s -> {
            System.out.println("-> " + s);
        });
    }
}