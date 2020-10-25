import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] commands = command.split(" ");
            int index;
            switch (commands[0]) {
                case "exchange":
                    index = Integer.parseInt(commands[1]);
                    if (index > array.length - 1 || index < 0) {
                        System.out.println("Invalid index");
                    } else {
                        array = exchange(array, index);
                    }
                    break;
                case "max":
                    int max = max(array, commands);
                    if (max == -1) {
                        System.out.println("No matches");
                    } else {
                        System.out.println(max);
                    }
                    break;
                case "min":
                    int min = min(array, commands);
                    if (min == -1) {
                        System.out.println("No matches");
                    } else {
                        System.out.println(min);
                    }
                    break;
                case "first":
                    int count = Integer.parseInt(commands[1]);
                    String cmd = commands[2];
                    if (count > array.length || count < 1) {
                        System.out.println("Invalid count");
                    } else {
                        printArray(firstElements(array, count, cmd));
                    }
                    break;
                case "last":
                    count = Integer.parseInt(commands[1]);
                    cmd = commands[2];
                    if (count > array.length || count < 1) {
                        System.out.println("Invalid count");
                    } else {
                        printArray(lastElements(array, count, cmd));
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        printArray(array);
    }

    private static int[] exchange(int[] arr, int n) {
        int[] firstArray = new int[n + 1];
        int[] secondArray = new int[arr.length - n - 1];
        System.arraycopy(arr, 0, firstArray, 0, firstArray.length);
        System.arraycopy(arr, n + 1, secondArray, 0, secondArray.length);
        arr = new int[arr.length];
        System.arraycopy(secondArray, 0, arr, 0, secondArray.length);
        System.arraycopy(firstArray, 0, arr, secondArray.length, firstArray.length);
        return arr;
    }

    private static int max(int[] arr, String[] s) {
        int maxOdd = Integer.MIN_VALUE;
        int maxEven = Integer.MIN_VALUE;
        int maxEvenIndex = -1;
        int maxOddIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                if (arr[i] >= maxEven) {
                    maxEven = arr[i];
                    maxEvenIndex = i;
                }
            } else {
                if (arr[i] >= maxOdd) {
                    maxOddIndex = i;
                    maxOdd = arr[i];
                }
            }
        }
        switch (s[1]) {
            case "even":
                return maxEvenIndex;
            case "odd":
                return maxOddIndex;
        }
        return -1;
    }

    private static int min(int[] arr, String[] s) {
        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;
        int minOddIndex = -1;
        int minEvenIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                if (arr[i] <= minEven) {
                    minEven = arr[i];
                    minEvenIndex = i;
                }
            } else {
                if (arr[i] <= minOdd) {
                    minOdd = arr[i];
                    minOddIndex = i;
                }
            }
        }
        switch (s[1]) {
            case "even":
                return minEvenIndex;
            case "odd":
                return minOddIndex;
        }
        return -1;
    }

    private static int[] firstElements(int[] arr, int n, String s) {
        int count = 0;
        if (s.equals("even")) {
            int[] evenArray = new int[n];
            Arrays.fill(evenArray, -1);
            for (int j : arr) {
                if (j % 2 == 0 && count < evenArray.length) {
                    evenArray[count] = j;
                    count++;
                }
            }
            return evenArray;
        } else {
            int[] oddArray = new int[n];
            Arrays.fill(oddArray, -1);
            for (int j : arr) {
                if (j % 2 == 1 && count < oddArray.length) {
                    oddArray[count] = j;
                    count++;
                }
            }
            return oddArray;
        }
    }

    private static int[] lastElements(int[] arr, int n, String s) {
        int count = 0;
        if (s.equals("even")) {
            int[] evenArray = new int[n];
            Arrays.fill(evenArray, -1);
            for (int i = arr.length; i > 0; i--) {
                int j = arr[i - 1];
                if (j % 2 == 0 && count < evenArray.length) {
                    evenArray[count] = j;
                    count++;
                }
            }
            return reverseArray(evenArray);
        } else {
            int[] oddArray = new int[n];
            Arrays.fill(oddArray, -1);
            for (int i = arr.length; i > 0; i--) {
                int j = arr[i - 1];
                if (j % 2 == 1 && count < oddArray.length) {
                    oddArray[count] = j;
                    count++;
                }
            }
            return reverseArray(oddArray);
        }
    }

    private static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (array[i] == -1) {
                continue;
            }
            if (i == array.length - 1) {
                System.out.print(array[i]);
            } else if (array[i + 1] != -1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.print(array[i]);
            }
        }
        System.out.println("]");
    }

    private static int[] reverseArray(int[] array){
        int[] b = new int[array.length];
        int j = array.length;
        for (int k : array) {
            b[j - 1] = k;
            j = j - 1;
        }
        return b;
    }
}