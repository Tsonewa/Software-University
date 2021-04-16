import java.util.Scanner;

public class RepeatStrings {

    public static String repeatWord (String word, int countRepeats){
        String[] copy = new String[countRepeats];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = word;
        }
        return String.join("", copy);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");
        String[] repeatedWords = new String[words.length];

        for (int i = 0; i < words.length ; i++) {
            repeatedWords[i] = repeatWord(words[i], words[i].length());
        }
        System.out.printf(String.join("", repeatedWords));
    }
}