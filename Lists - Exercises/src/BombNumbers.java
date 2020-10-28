import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int bomb = Integer.parseInt(scanner.next());
        int power = Integer.parseInt(scanner.next());
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == bomb) {
                for (int j = 1; j <= power; j++) {
                    if (i-j < 0){
                        break;
                    } else {
                        numbers.set(i - j, 0);
                    }
                }
                for (int j = 1; j <= power; j++) {
                    if(i + j > numbers.size() - 1){
                        break;
                    } else {
                        numbers.set(i + j, 0);
                    }
                }
                numbers.set(i,0);
            }
        }
        numbers.removeAll(Collections.singletonList(0));
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println(sum);
    }
}
