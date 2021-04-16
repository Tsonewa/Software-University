import java.util.Scanner;

public class MultiplicationTableSecondEdition {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input

        int n = scanner.nextInt();
        int secondNumber = scanner.nextInt();
        int times = secondNumber;
        int lenght = secondNumber - 1;

        if (secondNumber > 10) {
            int multiply = n * secondNumber;
            System.out.printf("%d X %d = %d", n, secondNumber, multiply);
        } else {
            while (times <= 10) {
                int number = n * secondNumber;
                times++;
                lenght++;
                secondNumber++;
                System.out.printf("%d X %d = %d%n ", n, lenght, number);
            }
        }
    }
}
