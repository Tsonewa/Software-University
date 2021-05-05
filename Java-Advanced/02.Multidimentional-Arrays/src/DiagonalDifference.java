import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int i = 0; i < size ; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }
        int primaryDiagonal = findPrimaryDiagonal(matrix);
        int secondaryDiagonal = findSecondaryDiagonal(matrix);
        System.out.println(Math.abs(primaryDiagonal - secondaryDiagonal));
    }

    private static int findSecondaryDiagonal(int[][] matrix) {
        int secondaryDiagonal = 0;

        for (int row = 0; row < matrix.length ; row++) {
                secondaryDiagonal += matrix[row][matrix[row].length - 1 - row];
        }
        return secondaryDiagonal;
    }

    private static int findPrimaryDiagonal(int[][] matrix) {
        int primaryDiagonal = 0;

        for (int row = 0; row < matrix.length ; row++) {
                primaryDiagonal += matrix[row][row];

        }
        return primaryDiagonal;
    }
}
