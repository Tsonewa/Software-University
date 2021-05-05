import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*On the first line you are given a list of numbers. On the next lines you are passed different -> Checked
         commands that you need to apply to all numbers in the list:
         The input will end with an "end" command, after which you need to print the result.
         */
        Function<int[], int[]> add = arr -> Arrays.stream(arr).map(e -> e += 1).toArray();
        Function<int[], int[]> multiply = arr -> Arrays.stream(arr).map(e -> e *= 2).toArray();
        Function<int[], int[]> subtract = arr -> Arrays.stream(arr).map(e -> e -= 1).toArray();
        Consumer<int[]> print = arr -> Arrays.stream(arr).forEach(e -> System.out.print(e + " "));

        int[] input = Arrays.stream(scanner.nextLine()
                .split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();
        while (!command.equals("end")){
            switch (command){
                case "add":
                    input = add.apply(input);
                    break;
                case "multiply":
                    input = multiply.apply(input);
                    break;
                case "subtract":
                    input = subtract.apply(input);
                    break;
                case "print":
                    print.accept(input);
                    System.out.println();
            }
            command = scanner.nextLine();
        }

    }
}
