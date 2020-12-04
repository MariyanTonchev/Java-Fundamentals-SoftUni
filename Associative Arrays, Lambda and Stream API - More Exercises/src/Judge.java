import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, LinkedHashMap<String, Integer>> contests = new LinkedHashMap<>();
        Map<String, TreeMap<String, Integer>> totalUserPoints = new TreeMap<>();
        Map<String, Integer> allPoints = new LinkedHashMap<>();
        while (!input.equals("no more time")) {
            String[] data = input.split(" -> ");
            String user = data[0];
            String contest = data[1];
            int points = Integer.parseInt(data[2]);
            contests.putIfAbsent(contest, new LinkedHashMap<>());
            contests.get(contest).putIfAbsent(user, points);
            totalUserPoints.putIfAbsent(user, new TreeMap<>());
            totalUserPoints.get(user).putIfAbsent(contest, 0);
            if (totalUserPoints.get(user).get(contest) < points) {
                totalUserPoints.get(user).put(contest, points);
            }
            if (contests.get(contest).get(user) < points) {
                contests.get(contest).put(user, points);
            }
            input = scanner.nextLine();
        }
        contests.forEach((key, value) -> {
            AtomicInteger i = new AtomicInteger();
            System.out.println(key + ": " + value.size() + " participants");
            value.entrySet().stream().sorted((a, b) -> {
                int result = b.getValue().compareTo(a.getValue());
                if (result == 0) {
                    result = a.getKey().compareTo(b.getKey());
                }
                return result;
            }).forEach(a -> {
                i.addAndGet(1);
                System.out.println(i + ". " + a.getKey() + " <::> " + a.getValue());
            });
        });

        int total = 0;
        for (Map.Entry<String, TreeMap<String, Integer>> entry : totalUserPoints.entrySet()) {
            if (entry.getValue().size() > 1) {
                for (Map.Entry<String, Integer> entry1 : entry.getValue().entrySet()) {
                    total += entry1.getValue();
                    allPoints.put(entry.getKey(), total);
                }
                total = 0;
            } else {
                for (Map.Entry<String, Integer> entry1 : entry.getValue().entrySet()) {
                    allPoints.put(entry.getKey(), entry1.getValue());
                }
            }
        }

        System.out.println("Individual standings:");
        AtomicInteger i = new AtomicInteger();
        allPoints.entrySet().stream().sorted((a, b) -> {
            int result = b.getValue().compareTo(a.getValue());
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(a -> {
            i.getAndIncrement();
            System.out.println(i + ". " + a.getKey() + " -> " + a.getValue());
        });
    }
}