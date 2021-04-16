import java.util.*;

public class MinerTask {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();
        LinkedHashMap<Character, Integer> count = new LinkedHashMap<>();

        for (int i = 0; i < input.length ; i++) {
            char letter = input[i];
            if (letter == ' '){
                continue;
            }
            count.putIfAbsent(letter, 0);
            int oldCount = count.get(letter);
            count.put(letter, oldCount + 1);
        }
        count.entrySet()
                .stream()
                .forEach(e -> System.out.printf("%c -> %d%n", e.getKey(), e.getValue()));
    }
}