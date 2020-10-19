import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int halfPower = N / 2;
        int M = scanner.nextInt();
        int Y = scanner.nextInt();
        int count = 0;
        while (N >= M){
            N -= M;
            count++;
            if (N == halfPower && Y != 0){
                N /= Y;
            }
        }
        System.out.printf("%d%n%d",N,count);
    }
}
