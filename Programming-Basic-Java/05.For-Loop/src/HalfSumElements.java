import java.util.Scanner;

public class HalfSumElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int n = Integer.parseInt(scanner.nextLine());
        int maxNumber = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            sum += number;

            if (number > maxNumber) {
                maxNumber = number;
            }
        }
        int total = sum - maxNumber;
        if (maxNumber == total) {
            System.out.println("Yes");
            System.out.println("Sum = " + maxNumber);
        } else {
            System.out.println("No");
            System.out.println("Diff = " + Math.abs(maxNumber - total));
        }
    }
    }