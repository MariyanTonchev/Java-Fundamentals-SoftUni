import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, List<String>> forces = new TreeMap<>();
        String input = scanner.nextLine();

        while (!input.equals("Lumpawaroo")) {
            String[] data;
            String cmd = "";
            if (input.contains("|")) {
                data = input.split("\\s+\\|\\s+");
                cmd = "|";
            } else {
                data = input.split("\\s+->\\s+");
                cmd = "->";
            }

            switch (cmd) {
                case "|":
                    String side = data[0];
                    String name = data[1];
                    boolean check = false;
                    for (Map.Entry<String, List<String>> current : forces.entrySet()) {
                        if (current.getValue().contains(name)) {
                            check = true;
                            break;
                        }
                    }
                    if (!check) {
                        if (!forces.containsKey(side)) {
                            forces.put(side, new ArrayList<>());
                            forces.get(side).add(name);
                        } else if (forces.containsKey(side) && !forces.get(side).contains(name)) {
                            forces.get(side).add(name);
                        }
                    }
                    break;
                case "->":
                    String user = data[0];
                    String whichSide = data[1];
                    for (Map.Entry<String, List<String>> current : forces.entrySet()) {
                        if (current.getValue().contains(user)) {
                            forces.get(current.getKey()).remove(user);
                            break;
                        }
                    }
                    if (!forces.containsKey(whichSide)) {
                        forces.put(whichSide, new ArrayList<>());
                        forces.get(whichSide).add(user);
                        System.out.printf("%s joins the %s side!%n", user, whichSide);
                    } else if (forces.containsKey(whichSide) && !forces.get(whichSide).contains(user)) {
                        forces.get(whichSide).add(user);
                        System.out.printf("%s joins the %s side!%n", user, whichSide);
                    }
                    break;
                default:
                    break;
            }
            input = scanner.nextLine();
        }

        forces.entrySet().stream()
                .filter(users -> users.getValue().size() > 0)
                .sorted(Map.Entry.<String, List<String>>comparingByValue(Comparator.comparing(List::size)).reversed())
                .forEach(s -> {
                    System.out.printf("Side: %s, Members: %d%n", s.getKey(), s.getValue().size());
                    s.getValue()
                            .stream()
                            .sorted(String::compareTo)
                            .forEach(person -> System.out.printf("! %s%n", person));
                });
    }
}