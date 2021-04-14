import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Map<Character, Integer> data = new TreeMap<>();

        for (int i = 0; i < text.length() ; i++) {
            char currentChar = text.charAt(i);
            data.putIfAbsent(currentChar, 0);
            data.put(currentChar, data.get(currentChar) + 1);
        }

        data.entrySet().stream()
                .forEach(entry -> {
                    System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue());
                });
    }
}
