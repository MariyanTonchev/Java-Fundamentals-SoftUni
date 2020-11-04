import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] stages = scanner.nextLine().split("\\|");
        int health = 100;
        int bitcoin = 0;
        int currentStage = 0;
        for (String s : stages) {
            if (health <= 0) {
                break;
            }
            String[] stage = s.split(" ");
            switch (stage[0]) {
                case "potion":
                    int healthPotion = Integer.parseInt(stage[1]);
                    currentStage++;
                    if (health + healthPotion > 100) {
                        healthPotion = 100 - health;
                    }
                    health += healthPotion;
                    System.out.printf("You healed for %d hp.%n", healthPotion);
                    System.out.printf("Current health: %d hp.%n", health);
                    break;
                case "chest":
                    int chestBitcoins = Integer.parseInt(stage[1]);
                    bitcoin += chestBitcoins;
                    currentStage++;
                    System.out.printf("You found %d bitcoins.%n", chestBitcoins);
                    break;
                default:
                    String monster = stage[0];
                    int monsterHealth = Integer.parseInt(stage[1]);
                    health -= monsterHealth;
                    currentStage++;
                    if (health > 0) {
                        System.out.printf("You slayed %s.%n", monster);
                    } else {
                        System.out.printf("You died! Killed by %s.%nBest room: %d", monster, currentStage);
                    }
                    break;
            }
        }
        if (health > 0) {
            System.out.printf("You've made it!%nBitcoins: %d%nHealth: %d", bitcoin, health);
        }
    }
}
