import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> distances = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> removed = new ArrayList<>();
        while (!distances.isEmpty()){
            int index = Integer.parseInt(scanner.nextLine());
            if (index < 0){
                int element = distances.get(0);
                removed.add(distances.get(0));
                distances.set(0,distances.get(distances.size()-1));
                for (int i = 0; i < distances.size(); i++) {
                    if(distances.get(i) <= element){
                        distances.set(i,distances.get(i) + element);
                    } else {
                        distances.set(i, distances.get(i) - element);
                    }
                }
                continue;
            } else if (index > distances.size() - 1){
                int element = distances.get(distances.size() - 1);
                removed.add(distances.get(distances.size() - 1));
                distances.set(distances.size() - 1, distances.get(0));
                for (int i = 0; i < distances.size(); i++) {
                    if(distances.get(i) <= element){
                        distances.set(i,distances.get(i) + element);
                    } else {
                        distances.set(i, distances.get(i) - element);
                    }
                }
                continue;
            }
            int element = distances.get(index);
            distances.remove(index);
            removed.add(element);
            for (int i = 0; i < distances.size(); i++) {
                if(distances.get(i) <= element){
                    distances.set(i,distances.get(i) + element);
                } else {
                    distances.set(i, distances.get(i) - element);
                }
            }
        }
        int sum = 0;
        for (Integer integer : removed) {
            sum += integer;
        }
        System.out.println(sum);
    }
}
