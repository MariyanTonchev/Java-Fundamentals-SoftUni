import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> filtered = numbers.stream().filter(n -> n > average(numbers)).sorted(Comparator.comparing(n -> n)).collect(Collectors.toList());
        if(filtered.isEmpty()){
            System.out.println("No");
        } else if(filtered.size() <= 5){
            for (int i = filtered.size(); i > 0; i--) {
                System.out.print(filtered.get(i - 1) + " ");
            }
        } else {
            for (int i = filtered.size(); i > filtered.size() - 5; i--) {
                System.out.print(filtered.get(i - 1) + " ");
            }
        }
    }

    private static Double average(List<Integer> numbers){
        double sum = 0.0;
        int count = 0;
        for (int j : numbers) {
            sum += j;
            count++;
        }
        return sum/count;
    }
}
