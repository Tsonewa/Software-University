import java.util.Scanner;

public class EqualSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        String[] input = scanner.nextLine().split(" ");
        int[] numbers = new int[input.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        int index = -1;
        for (int i = 0; i < numbers.length ; i++) {
            int currentNum = i;
            int leftSum = 0;
            int rightSum = 0;

            for (int j = currentNum - 1; j >= 0; j--) {
                leftSum += numbers[j];
            }
            for (int k = currentNum + 1; k < numbers.length; k++) {
                rightSum += numbers[k];
            }
            if (leftSum == rightSum) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            System.out.println(index);
        } else {
            System.out.println("no");
        }
    }
}