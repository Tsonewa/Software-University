import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        String[] input  = scanner.nextLine().split(" ");
        int[] numbers = new int[input.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        int specialNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numbers.length - 1 ; i++) {
            int firstNumber = numbers[i];
            for (int j = i + 1; j < numbers.length ; j++) {
                int secondNumber = numbers[j];
                if (firstNumber + secondNumber == specialNumber) {
                    System.out.println(firstNumber + " " + secondNumber);
                }
            }
        }
    }
}