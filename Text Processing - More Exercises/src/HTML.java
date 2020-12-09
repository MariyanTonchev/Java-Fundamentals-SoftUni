import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        System.out.printf("<h1>%n  %s%n</h1>%n", title);
        String article = scanner.nextLine();
        System.out.printf("<article>%n  %s%n</article>%n", article);
        String comment = scanner.nextLine();
        while (!comment.equals("end of comments")) {
            System.out.printf("<div>%n  %s%n</div>%n", comment);
            comment = scanner.nextLine();
        }
    }
}