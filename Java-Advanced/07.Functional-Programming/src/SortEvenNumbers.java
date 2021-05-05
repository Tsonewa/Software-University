
import java.util.Arrays;
        import java.util.Scanner;
        import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        String collect = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(collect);

        String collect1 = Arrays.stream(input).mapToInt(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(collect1);
    }
}