import java.util.*;
import java.util.stream.Collectors;

public class WordSynonyms {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        HashMap<Integer, Integer> countRepeats = new HashMap<>();

        for (int number : numbers) {

            if (!countRepeats.containsKey(number)) {
                countRepeats.putIfAbsent(number, 0);
                countRepeats.put(number, countRepeats.get(number) + 1);
            } else {
                int old = countRepeats.get(number);
                countRepeats.put(number, old + 1);
            }
        }
        countRepeats
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int first = e1.getKey();
                    int second = e2.getKey();
                    int result = Integer.compare(first, second);
                    return result;
                }).forEach(e -> System.out.printf("%d -> %d%n", e.getKey(), e.getValue()));
    }
}
