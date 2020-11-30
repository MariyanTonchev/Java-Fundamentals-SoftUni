import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> keyMaterials = new HashMap<>();
        Map<String, Integer> junkMaterials = new TreeMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        boolean isObtained = false;
        while (!isObtained) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int i = 0; i < tokens.length; i += 2) {
                int amount = Integer.parseInt(tokens[i]);
                String material = tokens[i + 1].toLowerCase();
                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")){
                    keyMaterials.put(material, keyMaterials.get(material) + amount);
                    if(keyMaterials.get(material) >= 250){
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        if (material.equals("shards")){
                            System.out.println("Shadowmourne obtained!");
                        } else if(material.equals("fragments")){
                            System.out.println("Valanyr obtained!");
                        } else {
                            System.out.println("Dragonwrath obtained!");
                        }
                        isObtained = true;
                        break;
                    }
                } else {
                    junkMaterials.putIfAbsent(material, 0);
                    junkMaterials.put(material, junkMaterials.get(material) + amount);
                }
            }
        }
        keyMaterials.entrySet()
                .stream()
                .sorted((a,b) -> {
                    int result = b.getValue().compareTo(a.getValue());
                    if (result == 0) {
                        result = a.getKey().compareTo(b.getKey());
                    }
                    return result;
                }).forEach(c -> System.out.printf("%s: %d%n", c.getKey(), c.getValue()));
        junkMaterials.forEach((k,v) -> System.out.println(k + ": " + v));
    }
}