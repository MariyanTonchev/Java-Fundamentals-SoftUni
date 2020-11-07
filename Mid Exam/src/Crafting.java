import java.util.Scanner;

public class Crafting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] weapons = scanner.nextLine().split("\\|");
        String input = scanner.nextLine();
        while (!input.equals("Done")) {
            String[] data = input.split(" ");
            if (data[0].equals("Move")) {
                if (data[1].equals("Left")) {
                    for (int i = 0; i < weapons.length; i++) {
                        int index = Integer.parseInt(data[2]);
                        if (index > 0 && index <= weapons.length) {
                            String weapon = weapons[index];
                            String temp = weapons[index - 1];
                            weapons[index - 1] = weapon;
                            weapons[index] = temp;
                            break;
                        }
                    }
                } else {
                    for (int i = 0; i < weapons.length; i++) {
                        int index = Integer.parseInt(data[2]);
                        if (index >= 0 && index + 1 < weapons.length) {
                            String weapon = weapons[index];
                            String temp = weapons[index + 1];
                            weapons[index + 1] = weapon;
                            weapons[index] = temp;
                            break;
                        }
                    }
                }
            } else if (data[0].equals("Check")) {
                if(data[1].equals("Even")){
                    for (int i = 0; i < weapons.length; i++) {
                        if(i%2 == 0){
                            System.out.print(weapons[i] + " ");
                        }
                    }
                } else {
                    for (int i = 0; i < weapons.length; i++) {
                        if(i%2 == 1){
                            System.out.print(weapons[i] + " ");
                        }
                    }
                }
                System.out.println();
            }
            input = scanner.nextLine();
        }
        StringBuilder name = new StringBuilder();
        for (String weapon : weapons) {
            name.append(weapon);
        }
        System.out.printf("You crafted %s!", name.toString());
    }
}
