import java.util.Scanner;

public class Articles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(", ");
        Article article = new Article(data[0],data[1],data[2]);
        int n = scanner.nextInt();
        for (int i = 0; i <= n; i++) {
            String[] input = scanner.nextLine().split(": ");
            switch (input[0]){
                case "Edit":
                    article.edit(input[1]);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(input[1]);
                    break;
                case "Rename":
                    article.rename(input[1]);
                    break;
            }
        }
        System.out.println(article.toString());
    }

    private static class Article {
        String title;
        String content;
        String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        @Override
        public String toString() {
            return title + " - " + content + ": " + author;
        }

        public void edit(String newContent){
            content = newContent;
        }

        public void changeAuthor(String newAuthor){
            author = newAuthor;
        }

        public void rename(String newTitle){
            title = newTitle;
        }
    }
}
