import java.util.*;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> text = Arrays.stream(scanner.nextLine().split("\\s+")).map(String::valueOf).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("3:1")) {
            List<String> command = Arrays.asList(input.split("\\s+"));
            int n1 = Integer.parseInt(command.get(1));
            int n2 = Integer.parseInt(command.get(2));
            if (command.get(0).equals("merge")) {
                merge(text, n1, n2);
            } else if (command.get(0).equals("divide")) {
                divide(text, n1, n2);
            }
            input = scanner.nextLine();
        }
        System.out.println(text.toString().replaceAll("[]\\[,]", ""));
    }

    private static void merge(List<String> list, int start, int end) {
        if (start < 0) {
            start = 0;
        }
        if (end > list.size() - 1) {
            end = list.size() - 1;
        }
        for (int i = start + 1; i <= end; i++) {
            list.set(start, list.get(start) + list.get(start + 1));
            list.remove(list.get(start + 1));
        }
    }

    private static void divide(List<String> list, int index, int partition) {
        if (index >= 0 && index < list.size() && partition >= 0 && partition <= 100) {
            String element = list.get(index);
            list.remove(index);
            int partitionSize = element.length() / partition;
            int remainder = element.length() % partition;
            int count = 0;
            StringBuilder token = new StringBuilder();
            List<String> tempList = new ArrayList<>();
            for (int i = 0; i < element.length(); i++) {
                token.append(element.charAt(i));
                if (token.length() == partitionSize) {
                    tempList.addAll(Collections.singleton(token.toString()));
                    token = new StringBuilder();
                    count++;
                    if (count == partition - 1) {
                        partitionSize += remainder;
                    }
                }
            }
            list.addAll(index, tempList);
        }
    }
}
