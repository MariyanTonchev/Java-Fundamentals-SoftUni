import java.util.Scanner;

public class DataTypeFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("END")){
            boolean isInt = true;
            try {
                int n = Integer.parseInt(input);
            } catch (NumberFormatException e){
                isInt = false;
            }
            boolean isDouble = true;
            try {
                double n = Double.parseDouble(input);
            } catch (NumberFormatException e){
                isDouble = false;
            }

            if(isInt){
                System.out.printf("%s is integer type%n", input);
            } else if(input.equalsIgnoreCase("false") || input.equalsIgnoreCase("true")){
                System.out.printf("%s is boolean type%n", input);
            } else if(isDouble){
                System.out.printf("%s is floating point type%n", input);
            } else if(input.length() == 1){
                System.out.printf("%s is character type%n", input);
            } else {
                System.out.printf("%s is string type%n", input);
            }
            input = scanner.nextLine();
        }
    }
}
