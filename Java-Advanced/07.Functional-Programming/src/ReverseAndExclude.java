import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Write a program that reverses a collection
        // and removes elements that are divisible by a given integer n

        ArrayList<Integer> input = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
        int index = Integer.parseInt(scanner.nextLine());
        Predicate<Integer> checkIsItDivisible = e -> e % index != 0;
        Consumer<ArrayList<Integer>> reverse = Collections::reverse;

        ArrayList<Integer> collect = input.stream().mapToInt(Integer::intValue)
                .boxed()
                .filter(checkIsItDivisible)
                .collect(Collectors.toCollection(ArrayList::new));

        reverse.accept(collect);
        collect.forEach(e -> System.out.print(e + " "));
    }
    }
