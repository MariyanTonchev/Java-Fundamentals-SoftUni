import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, LinkedHashMap<String, String>> dragons = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] data = input.split(" ");
            String type = data[0];
            String name = data[1];
            int dmg = 0;
            int hp = 0;
            int armor = 0;
            if(data[2].equals("null")){
                dmg = 45;
            } else {
                dmg = Integer.parseInt(data[2]);
            }
            if(data[3].equals("null")){
                hp = 250;
            } else {
                hp = Integer.parseInt(data[3]);
            }
            if(data[4].equals("null")){
                armor = 10;
            } else {
                armor = Integer.parseInt(data[4]);
            }
            String stats = dmg + "/" + hp + "/" + armor;
            dragons.putIfAbsent(type, new LinkedHashMap<>());
            dragons.get(type).putIfAbsent(name, stats);
            if(dragons.get(type).containsKey(name)){
                dragons.get(type).put(name, stats);
            }
        }
        dragons.forEach((key, value) -> {
            double totalDmg = 0;
            double totalHealth = 0;
            double totalArmor = 0;
            String[] allStats = value.values().toArray(new String[0]);
            for (String allStat : allStats) {
                String[] currentStats = allStat.split("/");
                int dmg = Integer.parseInt(currentStats[0]);
                int health = Integer.parseInt(currentStats[1]);
                int armor = Integer.parseInt(currentStats[2]);
                totalDmg += dmg;
                totalHealth += health;
                totalArmor += armor;
            }
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", key, totalDmg / allStats.length, totalHealth / allStats.length, totalArmor / allStats.length);
            value.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(b -> {
                String[] stats = b.getValue().split("/");
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", b.getKey(), Integer.parseInt(stats[0]), Integer.parseInt(stats[1]), Integer.parseInt(stats[2]));
            });
        });
    }
}