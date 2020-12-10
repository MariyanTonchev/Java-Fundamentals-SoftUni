import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameRegex = "[A-Za-z]";
        String distRegex = "\\d";
        List<String> participants = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        Map<String, Integer> racers = new LinkedHashMap<>();
        Pattern namePattern = Pattern.compile(nameRegex);
        for (String participant : participants) {
            racers.putIfAbsent(participant, 0);
        }
        Pattern kmPatter = Pattern.compile(distRegex);
        String input = scanner.nextLine();
        while (!input.equals("end of race")) {
            Matcher nameMatcher = namePattern.matcher(input);
            StringBuilder name = new StringBuilder();
            while (nameMatcher.find()) {
                name.append(nameMatcher.group());
            }
            if (racers.containsKey(name.toString())) {
                int currentDistance = racers.get(name.toString());
                Matcher kmMatcher = kmPatter.matcher(input);
                while (kmMatcher.find()) {
                    currentDistance += Integer.parseInt(kmMatcher.group());
                }
                racers.put(name.toString(), currentDistance);
            }
            input = scanner.nextLine();
        }
        List<String> topThree = racers.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue())).limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        int count = 1;
        for (String top : topThree){
            switch (count++){
                case 1:
                    System.out.println("1st place: " + top);
                    break;
                case 2:
                    System.out.println("2nd place: " + top);
                    break;
                case 3:
                    System.out.println("3rd place: " + top);
                    break;
            }
        }
    }
}