import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        int area = (int) getRectangleArea(width,height);
        System.out.println(area);
    }

    private static double getRectangleArea(double width, double height){
        return width * height;
    }
}
