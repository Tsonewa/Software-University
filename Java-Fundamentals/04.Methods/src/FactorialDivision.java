import java.util.Scanner;

public class FactorialDivision {

    public static double printFactorial (int firstNumber) {
        double sum = 1.0;
        for (int i = 1; i <= firstNumber ; i++) {
            sum *= i;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Factorial == 5! = 5 x 4 x 3 x 2 x 1 = 120;

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        printFactorial(firstNumber);
        printFactorial(secondNumber);
        double divide = printFactorial(firstNumber) / printFactorial(secondNumber);
        System.out.printf("%.2f", divide);
    }
}