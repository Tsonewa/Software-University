import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String key = scanner.nextLine();
        String word = scanner.nextLine();

        int startIndex = word.indexOf(key);

        while (startIndex != -1){
            word = word.replace(key, "");

            startIndex = word.indexOf(key);
        }
        System.out.print(word);
    }
}
