import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] data = input.split(" ");
            String cmd = data[0];
            switch (cmd) {
                case "swap":
                    swap(array, data);
                    break;
                case "multiply":
                    multiply(array,data);
                    break;
                case "decrease":
                    decrease(array);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(Arrays.toString(array).replaceAll("[\\[\\]]", " ").trim());
    }

    private static void swap(int[] arr, String[] data) {
        int index1 = Integer.parseInt(data[1]);
        int index2 = Integer.parseInt(data[2]);
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private static void multiply(int[] arr, String[] data){
        int index1 = Integer.parseInt(data[1]);
        int index2 = Integer.parseInt(data[2]);
        arr[index1] = arr[index1] * arr[index2];
    }

    private static void decrease(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] - 1;
        }
    }
}
