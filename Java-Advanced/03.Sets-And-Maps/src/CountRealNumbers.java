import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<Double, Integer> numbers = new LinkedHashMap<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).forEach(e -> {
                    numbers.putIfAbsent(e, 0);
                    numbers.put(e, numbers.get(e) + 1);
                });

        numbers.entrySet().stream().forEach(e -> {
            System.out.printf("%.1f -> %d%n",  e.getKey(), e.getValue());
        });
    }

}
