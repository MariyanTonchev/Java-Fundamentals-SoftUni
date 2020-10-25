import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOne = Integer.parseInt(scanner.nextLine());
        int numTwo = Integer.parseInt(scanner.nextLine());
        int numThree = Integer.parseInt(scanner.nextLine());
        printSmallestNumber(numOne, numTwo, numThree);
    }

    private static void printSmallestNumber(int n1, int n2, int n3) {
        System.out.println(Math.min(n1,Math.min(n2,n3)));
    }
}
