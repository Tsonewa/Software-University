import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationsAdvanced {
    public static void checkForContains(List<Integer> numbers, String[] operation) {
        int number = Integer.parseInt(operation[1]);
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int curNum = numbers.get(i);
            if (curNum == number) {
                count++;
            }
        }
        if (count == 0){
            System.out.print("No such number");
        }else {
            System.out.print("Yes");
        }
    }
    public static void printEvenDigits (List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            int curNum = numbers.get(i);
            if (curNum % 2 == 0) {
                System.out.print(curNum + " ");
            }
        }
    }
    public static void printOddDigits(List<Integer> numbers){
        for (int j = 0; j < numbers.size(); j++) {
            int curOddnum = numbers.get(j);
            if (curOddnum % 2 != 0) {
                System.out.print(curOddnum + " ");
            }
        }
    }
    public static void sumOfAll(List<Integer> numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        System.out.print(sum);
    }
    public static void compareToOperator(List<Integer> numbers, String[] operation){
        String operator = operation[1];
        int number = Integer.parseInt(operation[2]);

        switch (operator) {
            case "<":
                for (int i = 0; i < numbers.size(); i++) {
                    int curNum = numbers.get(i);
                    if (curNum < number) {
                        System.out.print(curNum + " ");
                    }
                }
                break;
            case ">":
                for (int i = 0; i < numbers.size(); i++) {
                    int curNum = numbers.get(i);
                    if (curNum > number) {
                        System.out.print(curNum + " ");
                    }
                }
                break;
            case "<=":
                for (int i = 0; i < numbers.size(); i++) {
                    int curNum = numbers.get(i);
                    if (curNum <= number) {
                        System.out.print(curNum + " ");
                    }
                }
                break;
            case ">=":
                for (int i = 0; i < numbers.size(); i++) {
                    int curNum = numbers.get(i);
                    if (curNum >= number) {
                        System.out.print(curNum + " ");
                    }
                }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String line = scanner.nextLine();

        while (!line.equals("end")){
            String[] operation = line.split(" ");

            switch (operation[0]){
                case "Contains" :
                    checkForContains(numbers, operation);
                    break;
                case "Print" :
                    String oddOrEven = operation[1];
                    if (oddOrEven.equals("even")){
                        printEvenDigits(numbers);
                        break;
                    }else if (oddOrEven.equals("odd")) {
                        printOddDigits(numbers);
                        break;
                    }
                case "Get":
                    sumOfAll(numbers);
                    break;
                case "Filter":
                    compareToOperator(numbers, operation);
            }
            System.out.println();
            line = scanner.nextLine();
        }
    }
}
