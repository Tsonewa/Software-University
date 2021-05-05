import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" "); // "3" "3" "6" ""1"

        List<Double> numbers = new ArrayList<>();  // 3 ,3 ,6, 1
        for (int i = 0; i < input.length; i++) {
            numbers.add(Double.parseDouble(input[i]));
        }

        for (int i = 0; i < numbers.size() - 1; i++) { // 3,3,6,1
            if (numbers.get(i).equals(numbers.get(i + 1))) {
                numbers.set(i, numbers.get(i) + numbers.get(i + 1));
                numbers.remove(i + 1);
                i = -1;
            }
        }
        String output = joinStringByDelimiter(numbers, " ");
        System.out.println(output);
    }

    static String joinStringByDelimiter(List<Double> numbers, String delimiter) {
        String output = "";
        for (Double number : numbers) {
            output += (new DecimalFormat("0.#").format(number) + delimiter);
        }
        return output;
    }
}
