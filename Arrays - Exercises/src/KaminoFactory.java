import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        int bestIndex = Integer.MAX_VALUE;
        int bestSum = 0;
        int mostLeftIndex = 0;
        int bestLeftIndex = 0;
        int[] bestDNA = new int[size];

        while (!input.equals("Clone them!")) {
            ++mostLeftIndex;

            int[] DNA = Arrays.stream(input.split("!+")).mapToInt(Integer::parseInt).toArray();

            int maxCount = 0;
            int index = 0;
            for (int i = 0; i < DNA.length; i++) {
                int currentCount = 0;
                for (int j = i; j < DNA.length; j++) {
                    if (DNA[i] == DNA[j]) {
                        currentCount++;
                        if (currentCount > maxCount) {
                            maxCount = currentCount;
                            index = i;
                        }
                    } else {
                        break;
                    }
                }
            }
            int sum = 0;
            for (int i = 0; i < DNA.length; i++) {
                if (DNA[i] == 1) {
                    sum += DNA[i];
                }
            }
            if (index < bestIndex || sum > bestSum) {
                bestIndex = index;
                bestSum = sum;
                bestLeftIndex = mostLeftIndex;
                bestDNA = DNA;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", bestLeftIndex, bestSum);
        for (int j : bestDNA) {
            System.out.print(j + " ");
        }
    }
}