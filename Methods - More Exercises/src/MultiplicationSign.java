import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());
        printSign(n1,n2,n3);
    }

    private static void printSign(int n1, int n2, int n3){
        int minus = 0;
        if(n1 < 0){
            minus++;
        }
        if(n2 < 0){
            minus++;
        }
        if(n3 < 0){
            minus++;
        }
        if(n1 == 0 || n2 == 0 || n3 == 0){
            System.out.println("zero");
        } else if(n1 + n2 + n3 == 0){
            System.out.println("zero");
        } else {
            if (minus % 2 == 1) {
                System.out.println("negative");
            } else {
                System.out.println("positive");
            }
        }
    }
}
