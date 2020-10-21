import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfField = Integer.parseInt(scanner.nextLine());
        int[] bugsIndexes = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] field = new int[sizeOfField];
        for (int bug : bugsIndexes) {
            if (bug >= 0 && bug < field.length) {
                field[bug] = 1;
            }
        }
        String input = scanner.nextLine();
        while (!input.equals("end")){
            String[] instructions = input.split(" ");
            int bugIndex = Integer.parseInt(instructions[0]);
            String direction = instructions[1];
            int flyLength = Integer.parseInt(instructions[2]);
            if(bugIndex < 0 || bugIndex >= field.length || field[bugIndex] != 1){
                input = scanner.nextLine();
                continue;
            }
            field[bugIndex] = 0;
            if(direction.equals("right")){
                bugIndex += flyLength;
                while (bugIndex < field.length && field[bugIndex] == 1){
                    bugIndex += flyLength;
                }
                if(bugIndex<field.length){
                    field[bugIndex] = 1;
                }
            } else {
                bugIndex -= flyLength;
                while (bugIndex >= 0 && field[bugIndex] == 1){
                    bugIndex -= flyLength;
                }
                if(bugIndex>=0){
                    field[bugIndex] = 1;
                }
            }
            input = scanner.nextLine();
        }
        for (int j : field) {
            System.out.print(j + " ");
        }
    }
}
