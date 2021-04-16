import java.util.Scanner;

public class TextFillter {
    public static String removeOccurences(String key, String word){
        int startIndex = word.indexOf(key);
        int count = key.length();
        String replace = "";

        for (int i = 0; i < count ; i++) {
            replace += "*";
        }
        while (startIndex != -1){
            word = word.replace(key, replace);

            startIndex = word.indexOf(key);
        }
        return word;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] keyWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (int i = 0; i < keyWords.length ; i++) {
            String key = keyWords[i];
            text = removeOccurences(key, text);

        }
        System.out.print(text);
    }
}
