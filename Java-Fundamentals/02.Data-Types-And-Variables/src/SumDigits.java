import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int number = Integer.parseInt(scanner.nextLine());
        int digitSum = 0;
        for (int i = number; i >= 0 ; i--) {
            int digit = number % 10;
            digitSum += digit;
            number /= 10;
        }
        System.out.println(digitSum);
    }
}
