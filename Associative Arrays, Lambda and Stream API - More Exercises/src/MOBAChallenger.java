import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Integer>> players = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Season end")) {
            String[] data = input.split(" ");
            String cmd = data[1];
            if (cmd.equals("->")) {
                String player = data[0];
                String position = data[2];
                int skill = Integer.parseInt(data[4]);
                LinkedHashMap<String, Integer> current = new LinkedHashMap<>();
                current.put(position, skill);
                if (!players.containsKey(player)) {
                    players.put(player, current);
                } else {
                    if (!players.get(player).containsKey(position)) {
                        players.get(player).put(position, skill);
                    } else {
                        if (players.get(player).get(position) < skill) {
                            players.get(player).put(position, skill);
                        }
                    }
                }
            } else if (cmd.equals("vs")) {
                String player1 = data[0];
                String player2 = data[2];
                if (players.containsKey(player1) && players.containsKey(player2)) {
                    boolean hasCommon = false;
                    for (String s : players.get(player1).keySet()) {
                        for (String s1 : players.get(player2).keySet()) {
                            if (s.equals(s1)) {
                                hasCommon = true;
                                break;
                            }
                        }
                    }
                    if (hasCommon) {
                        if (players.get(player1).values().stream().mapToInt(i -> i).sum() >
                                players.get(player2).values().stream().mapToInt(i -> i).sum()) {
                            players.remove(player2);
                        } else if (players.get(player1).values().stream().mapToInt(i -> i).sum() <
                                players.get(player2).values().stream().mapToInt(i -> i).sum()) {
                            players.remove(player1);
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }

        players.entrySet()
                .stream()
                .sorted((p1, p2) -> {
                    int result = Integer.compare(p2.getValue().values().stream().mapToInt(i -> i).sum(),
                            p1.getValue().values().stream().mapToInt(i -> i).sum());
                    if (result == 0) {
                        result = p1.getKey().compareTo(p2.getKey());
                    }
                    return result;
                })
                .forEach(entry -> {
                    System.out.printf("%s: %d skill%n", entry.getKey(), entry.getValue().values().stream().mapToInt(i -> i).sum());
                    entry.getValue()
                            .entrySet()
                            .stream()
                            .sorted((e1, e2) -> {
                                int res = Integer.compare(e2.getValue(), e1.getValue());
                                if (res == 0) {
                                    res = e1.getKey().compareTo(e2.getKey());
                                }
                                return res;
                            }).forEach(e -> {
                        System.out.printf("- %s <::> %d%n", e.getKey(), e.getValue());
                    });
                });
    }
}