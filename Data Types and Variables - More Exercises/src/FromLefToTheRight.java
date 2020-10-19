import java.util.Scanner;

public class FromLefToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i=0; i<n; i++){
            long numOne = scanner.nextLong();
            long numTwo = scanner.nextLong();
            int sum = 0;
            if(numOne > numTwo){
                while (numOne != 0){
                    sum += numOne%10;
                    numOne /= 10;
                }
            } else {
                while (numTwo != 0){
                    sum += numTwo%10;
                    numTwo /= 10;
                }
            }
            System.out.println(Math.abs(sum));
        }
    }
}
