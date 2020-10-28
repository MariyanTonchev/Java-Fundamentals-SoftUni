import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> deckOne = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> deckTwo = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        while (true){
            int playerOneHand = deckOne.get(0);
            int playerTwoHand = deckTwo.get(0);
            if (playerOneHand > playerTwoHand){
                deckOne.add(playerOneHand);
                deckOne.add(playerTwoHand);
            } else if (playerOneHand < playerTwoHand){
                deckTwo.add(playerTwoHand);
                deckTwo.add(playerOneHand);
            }
            deckOne.remove(deckOne.get(0));
            deckTwo.remove(deckTwo.get(0));
            if (deckOne.isEmpty()){
                System.out.printf("Second player wins! Sum: %d",sum(deckTwo));
                break;
            } else if(deckTwo.isEmpty()){
                System.out.printf("First player wins! Sum: %d",sum(deckOne));
                break;
            }
        }
    }

    private static int sum(List<Integer> list){
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        return sum;
    }
}
