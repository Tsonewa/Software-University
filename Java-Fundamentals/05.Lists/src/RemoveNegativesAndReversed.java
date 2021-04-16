import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveNegativesAndReversed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < numbers.size(); i++) {
            int curNum = numbers.get(i);
            if (curNum < 0) {
                numbers.remove(i);
                i--;
            }
        }
        Collections.reverse(numbers);
        if (numbers.size() == 0) {
            System.out.print("empty");
        } else {
            for (int number : numbers) {
                System.out.print(number + " ");
            }
        }
    }
}
