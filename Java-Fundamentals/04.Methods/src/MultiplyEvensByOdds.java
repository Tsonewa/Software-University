import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static int sumEvenOdd(int number){
        int evenNumber = 0;
        int oddNumber = 0;

        while (number != 0) {
            int digit = number % 10;
            if (digit % 2 == 0) {
                oddNumber += digit;
            } else {
                evenNumber += digit;
            }
            number = number / 10;
        }
        int sum = Math.abs(evenNumber * oddNumber);
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        Create a program that reads an integer number
         and multiplies the sum of all its even digits by the sum of all its odd digits:
         12345 has 2 even digits - 2 and 4. Even digits have sum of 6.
         Also it has 3 odd digits - 1, 3 and 5. Odd digits have sum of 9.
         Multiply 6 by 9 and you get 54.
         */
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(sumEvenOdd(number));
    }
}
