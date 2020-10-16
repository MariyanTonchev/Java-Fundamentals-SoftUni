import java.util.Scanner;

public class SortNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOne = scanner.nextInt();
        int numTwo = scanner.nextInt();
        int numThree = scanner.nextInt();
        if((numOne <= numTwo) && (numTwo <= numThree)){
            System.out.println(numThree);
            System.out.println(numTwo);
            System.out.println(numOne);
        } else if(numOne <= numTwo){
            System.out.println(numTwo);
            System.out.println(numThree);
            System.out.println(numOne);
        } else if(numTwo >= numThree){
            System.out.println(numOne);
            System.out.println(numTwo);
            System.out.println(numThree);
        } else {
            System.out.println(numThree);
            System.out.println(numOne);
            System.out.println(numTwo);
        }
    }
}
