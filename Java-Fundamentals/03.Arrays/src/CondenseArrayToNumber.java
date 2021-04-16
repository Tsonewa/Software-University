import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        String[] inputLine = scanner.nextLine().split(" ");
        int[] numbers = new int[inputLine.length];
        for (int i = 0; i < inputLine.length; i++) {
            numbers[i] = Integer.parseInt(inputLine[i]);
        }
        while (numbers.length > 1) {
            int[] digitAfterSum = new int[numbers.length - 1];
            for (int i = 0; i < numbers.length -1 ; i++) {
                digitAfterSum[i] = numbers[i] + numbers[i + 1];

            }
            numbers = digitAfterSum;
        }
        System.out.println(numbers[0]);
    }
}


