import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        LinkedHashMap<String, Integer> counts = new LinkedHashMap<>();

        for (String word: words) {
            String lowerCaseWords = word.toLowerCase();

            if (!counts.containsKey(lowerCaseWords)){
                counts.put(lowerCaseWords, 1);
            }else {
                counts.put(lowerCaseWords, counts.get(lowerCaseWords) + 1);
            }
        }
        ArrayList<String> oddLenght = new ArrayList<>();

        for (var entry : counts.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                oddLenght.add(entry.getKey());
            }
        }
        for (int i = 0; i < oddLenght.size() ; i++) {
            System.out.print(oddLenght.get(i));
            if (i < oddLenght.size() - 1){
                System.out.print(", ");
            }
        }
    }
}
