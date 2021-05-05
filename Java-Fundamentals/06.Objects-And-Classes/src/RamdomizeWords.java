import java.util.Random;
import java.util.Scanner;

public class RamdomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        Random wordGenerator = new Random();

        for (int i = 0; i < words.length; i++) {
            String temp = words[i];
            int rdm2 = wordGenerator.nextInt(words.length);
            words[i] = words[rdm2];
            words[rdm2] = temp;
        }
        for (String word: words
        ) {
            System.out.println(word);
        }
    }
}
