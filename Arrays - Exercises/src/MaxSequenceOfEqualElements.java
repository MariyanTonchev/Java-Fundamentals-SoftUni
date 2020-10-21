import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int longestSeqLen = 1;
        int longestSeqStart = 0;
        int currentSeqLen = 1;
        int currentSeqStart = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                currentSeqLen++;
                if (currentSeqLen > longestSeqLen) {
                    longestSeqLen = currentSeqLen;
                    longestSeqStart = currentSeqStart;
                }
            } else {
                currentSeqLen = 1;
                currentSeqStart = i;
            }
        }
        for (int i = longestSeqStart; i < longestSeqStart + longestSeqLen; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
