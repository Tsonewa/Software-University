import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        String[] firstLine = scanner.nextLine().split(" ");
        String[] secondLine = scanner.nextLine().split(" ");
        int[] lineNumbers = new int[firstLine.length];
        int[] secondLineNumber = new int[secondLine.length];

        boolean index = false;

        for (int i = 0; i < firstLine.length; i++) {
            lineNumbers[i] = Integer.parseInt(firstLine[i]);
        }
        for (int k = 0; k < secondLine.length; k++) {
            secondLineNumber[k] = Integer.parseInt(secondLine[k]);
        }
        int sum = 0;
        for (int i = 0; i < lineNumbers.length; i++) {
            if (lineNumbers[i] == secondLineNumber[i]) {
                sum += lineNumbers[i];
            } else {
                index = true;
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                break;
            }
        }
        if (!index ) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}
