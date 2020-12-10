import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> demons = Arrays.stream(scanner.nextLine().split("[,\\s]+")).collect(Collectors.toList());
        String regexHealth = "[^\\d+\\-*/.]";
        Pattern healthPattern = Pattern.compile(regexHealth);
        String regexDmg = "((?:-|\\+|)\\d+(?:\\.*?\\d+)*)";
        Pattern damagePattern = Pattern.compile(regexDmg);
        Map<String, Integer> demonsHealth = new LinkedHashMap<>();
        Map<String, Double> demonsDmg = new LinkedHashMap<>();
        String multiRegex = "[*]";
        Pattern multiPattern = Pattern.compile(multiRegex);
        String divRegex = "[/]";
        Pattern divPattern = Pattern.compile(divRegex);
        for (String demon : demons) {
            Matcher hpMatcher = healthPattern.matcher(demon);
            Matcher dmgMatcher = damagePattern.matcher(demon);
            Matcher divMatcher = divPattern.matcher(demon);
            Matcher multiMatcher = multiPattern.matcher(demon);
            int div = 1;
            int multi = 1;
            while (multiMatcher.find()) {
                multi *= 2;
            }
            while (divMatcher.find()) {
                div *= 2;
            }
            int health = 0;
            while (hpMatcher.find()) {
                String a = hpMatcher.group();
                health += a.charAt(0);
            }
            double dmg = 0;
            while (dmgMatcher.find()) {
                double a = Double.parseDouble(dmgMatcher.group());
                dmg += a;
            }
            demonsHealth.put(demon, health);
            demonsDmg.put(demon, dmg * multi / div);
        }
        demonsHealth.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(a -> System.out.printf("%s - %d health, %.2f damage%n", a.getKey(), a.getValue(), demonsDmg.get(a.getKey())));
    }
}