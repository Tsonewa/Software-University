import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Predicate<String> startWithUpperCase = word -> Character.isUpperCase(word.charAt(0));

        List<String> collect = Arrays.stream(text.split("\\s+"))
                .filter(startWithUpperCase)
                .collect(Collectors.toList());

        System.out.println(collect.size());
        System.out.print(collect.stream().collect(Collectors.joining(System.lineSeparator())));
    }
}
