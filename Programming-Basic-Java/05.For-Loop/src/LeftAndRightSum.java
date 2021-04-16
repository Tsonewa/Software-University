import java.util.Scanner;

public class LeftAndRightSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < n; i++) {
            int currentNunber = Integer.parseInt(scanner.nextLine());
            leftSum += currentNunber;

        }
        for (int i = 0; i < n; i++) {
            int currentNunber = Integer.parseInt(scanner.nextLine());
            rightSum += currentNunber;
        }
        if (leftSum == rightSum){
        System.out.print("Yes, sum = " + leftSum);
            }else {
            int diff = Math.abs(leftSum - rightSum);
            System.out.println ("No, diff = " + diff);
        }

    }
}
