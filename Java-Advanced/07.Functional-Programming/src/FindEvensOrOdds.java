import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.*;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //You are given a lower and an upper bound for a range of integer numbers.
        //Then a command specifies if you need to list all even or odd numbers in the given range.
        //Use predicates that need to be passed to a method.

        //1 ... 10
        int[] rangeNumbers = Arrays.stream(scanner.nextLine()
                .split("\\s+")).mapToInt(Integer::parseInt).toArray();
        // odd || even
        String operation = scanner.nextLine();

        ArrayList<Integer> numbers = createList(rangeNumbers);

        // check if digits are even
        Predicate<Integer> checkDigitEven = e -> e % 2 == 0;
        Predicate<Integer> checkDigitOdd = e -> e % 2 != 0;
        switch (operation){
            case "odd":
                numbers.stream().filter(checkDigitOdd)
                        .mapToInt(Integer::valueOf)
                        .forEach(e -> System.out.print(e + " "));
                break;
            case "even":
                numbers.stream().filter(checkDigitEven)
                        .mapToInt(Integer::valueOf)
                        .forEach(e -> System.out.print(e + " "));
        }
    }

    private static ArrayList<Integer> createList(int[] rangeNumbers) {
        int startIndex = rangeNumbers[0];
        int endIndex = rangeNumbers[1];
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = startIndex; i < endIndex + 1; i++) {
            result.add(i);
        }
        return result;
    }

}