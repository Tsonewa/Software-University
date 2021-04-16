import java.math.BigDecimal;
import java.util.Scanner;

public class MathOperations {

    public static double result (int firstNumber, String sigh, int secondNumber) {
        double finalSum = 0.0;
        /// * + -
        switch (sigh){
            case "*":
                finalSum = firstNumber * secondNumber;
                break;
            case "+":
                finalSum = firstNumber + secondNumber;
                break;
            case "-":
                finalSum = Math.abs(firstNumber - secondNumber);
                break;
            case "/":
                finalSum = (1.0 * firstNumber) / secondNumber;
                break;
        }
        return finalSum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        String sigh = scanner.nextLine();
        int secondNumber = Integer.parseInt(scanner.nextLine());

        if (result(firstNumber, sigh, secondNumber) % 2 == 0 || result(firstNumber, sigh, secondNumber) % 2 == 1) {
            System.out.printf("%.0f", result(firstNumber, sigh, secondNumber));
        } else {
            System.out.printf("%.2f", result(firstNumber, sigh, secondNumber));
        }
    }
}
