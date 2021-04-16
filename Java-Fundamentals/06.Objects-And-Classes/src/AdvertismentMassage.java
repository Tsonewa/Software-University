import java.util.Random;
import java.util.Scanner;

public class AdvertismentMassage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] phrases = {"Excellent product.", "Such a great product.",
                "I always use that product.", "Best product of its category.",
                "Exceptional product.", "I can’t live without this product."};

        String[] events = {"Now I feel good.", "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};

        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};

        String[] towns = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        Random rnd = new Random();

        int input = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < input ; i++) {
            String phrase = phrases[rnd.nextInt(phrases.length)];
            String event = events[rnd.nextInt(events.length)];
            String autor = authors[rnd.nextInt(authors.length)];
            String town = towns[rnd.nextInt(towns.length)];

            System.out.printf("%s %s %s - %s%n", phrase, event, autor, town);
        }
    }
}