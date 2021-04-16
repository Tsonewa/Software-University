import java.util.Arrays;
import java.util.Scanner;

public class TwoMatreces {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int row = Integer.parseInt(input[0]);
        int column = Integer.parseInt(input[1]);

        int[][] matrix = new int[row][column];

        for (int i = 0; i < row; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }
        int count = sumMatrixDigits(matrix);
        System.out.printf("%d%n%d%n%d%n", row, column, count);
    }

    private static int sumMatrixDigits (int[][] matrix) {
        int count = 0;

        for (int i = 0; i < matrix.length ; i++) {
            int[] line = matrix[i];
            for (int j = 0; j < line.length ; j++) {
                int currDigit = matrix[i][j];
                count += currDigit;
            }
        }

        return count;

    }

}
