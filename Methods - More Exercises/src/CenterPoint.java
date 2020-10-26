import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x1 = Integer.parseInt(scanner.nextLine());
        double y1 = Integer.parseInt(scanner.nextLine());
        double x2 = Integer.parseInt(scanner.nextLine());
        double y2 = Integer.parseInt(scanner.nextLine());
        double x3 = Integer.parseInt(scanner.nextLine());
        double y3 = Integer.parseInt(scanner.nextLine());
        double x4 = Integer.parseInt(scanner.nextLine());
        double y4 = Integer.parseInt(scanner.nextLine());
        printLongerLine(x1,y1,x2,y2,x3,y3,x4,y4);
    }

    private static boolean closestPoint(double x1, double x2, double y1, double y2) {
        double first = Math.sqrt(Math.pow(y1, 2) + Math.pow(x1, 2));
        double second = Math.sqrt(Math.pow(y2, 2) + Math.pow(x2, 2));
        boolean isFirstCloser = true;
        if (first >= second) {
            isFirstCloser = false;
        }
        return isFirstCloser;
    }

    private static void printLongerLine(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        double firstLineLen = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        double secondLineLen = Math.sqrt(Math.pow((x4 - x3), 2) + Math.pow((y4 - y3), 2));
        if (firstLineLen >= secondLineLen) {
            boolean isFirstCloser = closestPoint(x1, x2, y1, y2);
            if (isFirstCloser) {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x1, y1, x2, y2);
            } else {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x2, y2, x1, y1);
            }
        } else {
            boolean isFirstCloser = closestPoint(x3, x4, y3, y4);
            if (isFirstCloser) {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x3, y3, x4, y4);
            } else {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x4, y4, x3, y3);
            }
        }
    }
}

