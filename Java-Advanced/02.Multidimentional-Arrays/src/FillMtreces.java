import java.util.Scanner;

public class FillMtreces {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",");
        int number = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[number][number];
        int startNumber = 1;

        switch (pattern) {
            case "A":
                 matrix =  FillMatrixForward(number, matrix, startNumber);
                break;
            case "B":
                matrix = FillMatrixBackwords(number, matrix, startNumber);
                break;
                }
        PrintMatrix(matrix);
    }

    private static int[][] FillMatrixForward(int number, int[][] matrix, int startNumber) {
        for (int col = 0; col < number; col++) {
            for (int row = 0; row < number; row++) {
                matrix[row][col] = startNumber++;
            }
        }
        return matrix;
    }

    private static int[][] FillMatrixBackwords(int number, int[][] matrix, int startNumber) {
        for (int col = 0; col < number; col++) {
            if (col % 2 != 0) {
                for (int row = number - 1; row >= 0; row--) {
                    matrix[row][col] = startNumber++;
                }
            } else {
                for (int row = 0; row < number; row++) {
                    matrix[row][col] = startNumber++;
                }
            }
        }
        return matrix;
    }

    private static void PrintMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int[] arr = matrix[i];
            for (int j = 0; j < arr.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
