import java.util.Scanner;

public class Articles {

    public static class Article{
        //•	Title – a string
        //•	Content – a string
        //•	Author – a string

        String title;
        String content;
        String author;

        // Constructor:

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        //•	Edit (new content) – change the old content with the new
        public void edit(String content) {
            this.content = content;
        }

        //•	ChangeAuthor (new author) – change the author
        public void changeAuthor (String author) {
            this.author = author;
        }

        //•	Rename (new title) – change the title of the article
        public void rename (String title) {
            this.title = title;
        }

        //•	override ToString – print the article in the following format:
        @Override
        public String toString() {
            String result = String.format("%s - %s: %s", this.title, this.content, this.author);
            //"{title} - {content}:{author}"
            return result;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        String[] input = scanner.nextLine().split(", ");
        String title = input[0];
        String content = input[1];
        String author = input[2];
        int lines = Integer.parseInt(scanner.nextLine());

        Article article = new Article(title,content,author);
        for (int i = 0; i <lines ; i++) {
            input = scanner.nextLine().split(": ");
            String command = input[0];
            //Edit: {new content}"; "ChangeAuthor: {new author}"; "Rename: {new title}
            switch (command){
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
        System.out.print(article);
    }
}
