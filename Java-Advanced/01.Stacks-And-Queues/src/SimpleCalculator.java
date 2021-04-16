import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collector;

public class SimpleCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+"); // "4", "+", "3" ...
        ArrayDeque<String> numbers = new ArrayDeque<>();
        Collections.addAll(numbers, input);

        while (numbers.size() > 1){
            int firstDigit = Integer.parseInt(numbers.pop());
            String operator = numbers.pop();
            int secondDigit = Integer.parseInt(numbers.pop());

            if (operator.equals("+")){
                numbers.push(String.valueOf(firstDigit + secondDigit));
            }else if (operator.equals("-")){
                numbers.push(String.valueOf(firstDigit - secondDigit));
            }
        }
        System.out.println(numbers.peek());
    }
}
