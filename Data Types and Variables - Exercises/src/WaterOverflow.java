import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tankCapacity = 0;
        int n = scanner.nextInt();
        for (int i = 0; i<n; i++){
            int pour = scanner.nextInt();
            if(tankCapacity + pour <= 255){
                tankCapacity += pour;
            } else {
                System.out.println("Insufficient capacity!");
            }
        }
        System.out.println(tankCapacity);
    }
}
