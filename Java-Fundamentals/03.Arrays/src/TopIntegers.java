import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        String[] input = scanner.nextLine().split(" ");
        int[] numbers = new int[input.length];
        for (int i = 0; i < input.length ; i++) {
            numbers[i] = Integer.parseInt(input[i]);// 1..2..3..2..4
        }

        for (int j = 0; j < numbers.length - 1; j++) {
            boolean flag = true;
            int index = numbers[j];
            for (int k = j + 1; k < numbers.length; k++) {
                int secondNumber = numbers[k];
                if (index <= secondNumber) {
                    flag = false;
                }
            }
            if (flag) {
                System.out.print(index + " ");
            }
        }
        System.out.println(numbers[numbers.length -1]);
    }
}