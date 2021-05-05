import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        int magicNumber = Integer.parseInt(scanner.nextLine());
        int countCombination = 0;
        int countNumber = 0;
        int countTwo = 0;
        boolean combination = false;

        for (int i = start; i <= end; i++) {
            for (int j = start; j <= end; j++) {
                countCombination++;
                countNumber = i;
                countTwo = j;
                if (i + j == magicNumber) {
                    combination = true;
                    break;
                }
            }
            if (combination) {
                break;
            }
        }
        if (combination) {
            System.out.printf("Combination N:%d (%d + %d = %d)", countCombination, countNumber, countTwo, magicNumber);
        } else {
            System.out.printf("%d combinations - neither equals %d", countCombination, magicNumber);
        }
    }
}