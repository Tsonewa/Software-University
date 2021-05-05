import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestEleemnt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Function<ArrayList<Integer>, Integer> findMinElement = list -> list.stream()
                .min(Integer::compareTo)
                .get();

        ArrayList<Integer> input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));

        System.out.println(input.lastIndexOf(findMinElement.apply(input)));
    }
}
