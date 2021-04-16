import java.util.Arrays;
import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input

        String input = scanner.nextLine();
        String[] letters = input.split(" ");
        int[] digits = new int[letters.length];

        for (int i = 0; i < digits.length ; i++) {
            digits[i] = Integer.parseInt(letters[i]);
        }
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            int number = digits[i];
            if (number % 2 == 0){
                sum += digits[i];
            }
        }
        System.out.println(sum);
    }
}