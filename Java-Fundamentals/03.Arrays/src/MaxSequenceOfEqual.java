import java.util.Scanner;

public class MaxSequenceOfEqual {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //
        String[] input = scanner.nextLine().split(" ");
        int[] numbers = new int[input.length];
        for (int i = 0; i < numbers.length ; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        int lenght = 1;
        int endIndex = -1;
        int maxNumber = 0;
        for (int i = 0; i < numbers.length - 1 ; i++) {
            if (numbers[i] == numbers[i + 1]){
                lenght++;
                if (lenght > maxNumber) {
                    maxNumber = lenght;
                    endIndex = i + 1;
                }
            }else{
                lenght = 1;
            }
        }
        for (int i = endIndex; i > endIndex - maxNumber ; i--) {
            System.out.print(numbers[i] + " ");
        }
    }
}
