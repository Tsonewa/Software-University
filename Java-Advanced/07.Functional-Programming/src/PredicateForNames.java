import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bound = Integer.parseInt(scanner.nextLine());
        Predicate<String> checkNameLength = name -> name.length() <= bound;

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(checkNameLength)
                .collect(Collectors.toCollection(ArrayList::new))
                .forEach(System.out::println);
    }
}
