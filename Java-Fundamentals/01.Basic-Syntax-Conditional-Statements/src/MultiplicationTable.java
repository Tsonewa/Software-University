import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input

        int n = scanner.nextInt();
        int times = 0;

        for (int i = 1; i <= 10; i++) {
            int number = n * i;
            times ++;
            System.out.printf("%d X %d = %d%n ",n, times, number);
        }
    }
}