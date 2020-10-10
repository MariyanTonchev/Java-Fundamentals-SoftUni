import java.util.Scanner;

public class BackIn30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours = scanner.nextInt();
        int minutes = scanner.nextInt();
        if(minutes + 30 > 59){
            hours++;
            minutes = (minutes + 30) - 60;
        } else {
            minutes = minutes + 30;
        }
        if(hours > 23){
            hours = 0;
        }
        if(minutes < 10){
            System.out.println(hours + ":0" + minutes);
        } else {
            System.out.println(hours + ":" + minutes);
        }
    }
}
