import java.util.Scanner;

public class FillMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        switch (pattern){
            case "A":
                printMatrix(fillMatrixTopToBottom(size));
                break;
            case "B":
                printMatrix(fillMatrixLeftToRight(size));
                break;
        }
    }

    private static void printMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length ; row++) {
            for (int col = 0; col < matrix[row].length ; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrixLeftToRight(int size) {
        int[][] matrix = new int[size][size];
        int start = 1;

        for (int col = 0; col < matrix.length ; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix[col].length; row++) {
                    matrix[row][col] = start;
                    start++;
                }
            }else {
                for (int row = matrix[col].length - 1; row >= 0; row--) {
                    matrix[row][col] = start;
                    start++;
                }
            }
            }
        return matrix;
    }

    private static int[][] fillMatrixTopToBottom(int size) {

        int[][] matrix = new int[size][size];
        int start = 1;

        for (int row = 0; row < size ; row++) {
            for (int cols = 0; cols < size ; cols++) {
                matrix[cols][row] = start;
                start++;
            }
        }
        return matrix;
    }
}
