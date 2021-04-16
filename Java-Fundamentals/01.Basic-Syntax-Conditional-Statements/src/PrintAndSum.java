import java.util.Scanner;

public class PrintAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int input = Integer.parseInt(scanner.nextLine());
        int output = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = input; i <= output ; i++) {
            System.out.printf("%d ", i);
            sum += i;
        }
        System.out.println();
        System.out.printf("Sum: %d",sum);
    }
}
