import java.util.Scanner;

public class FixCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 0; i < n; i++) {
            System.out.println(2 * i + 1);
            sum += n;
        }
        System.out.printf("Sum: %d", sum);
    }
}