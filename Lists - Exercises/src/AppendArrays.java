import java.util.Scanner;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split("\\|");
        StringBuilder result = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            String[] currentArr = array[i].split("\\s+");
            for (String s : currentArr) {
                if (!s.equals("")) {
                    result.append(s).append(" ");
                }
            }
        }
        System.out.println(result);
    }
}
