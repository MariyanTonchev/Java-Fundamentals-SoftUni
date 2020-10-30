import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ArticlesVersionTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Article> articles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(", ");
            Article article = new Article(data[0], data[1], data[2]);
            articles.add(article);
        }
        String sortBy = scanner.nextLine();
        if(sortBy.equals("title")) {
            articles.stream().sorted(Comparator.comparing(Article::getTitle)).forEach(System.out::println);
        } else if(sortBy.equals("content")){
            articles.stream().sorted(Comparator.comparing(Article::getContent)).forEach(System.out::println);
        } else if(sortBy.equals("author")){
            articles.stream().sorted(Comparator.comparing(Article::getAuthor)).forEach(System.out::println);
        }
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

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return title + " - " + content + ": " + author;
        }
    }
}



