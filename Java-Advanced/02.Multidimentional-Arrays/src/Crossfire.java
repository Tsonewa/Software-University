import java.util.Arrays;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] rowAndCols = scanner.nextLine().split("\\s+");
        String[][] matrix = fillMatrix(rowAndCols);

        printMatrix(matrixDistraction(matrix, scanner));
    }
    private static void printMatrix(String[][] matrix) {
        for (String[] matrix1 : matrix) {
            for (String s : matrix1) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    private static String[][] matrixDistraction(String[][] matrix, Scanner scanner) {
        String input = scanner.nextLine();
        if (input.equals("Nuke it from orbit")) {
            return matrix;
        } else {
            int[] tokens = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int currentRow = tokens[0];
            int currentColumn = tokens[1];
            int radius = tokens[2];

            for (int row = 0; row <= radius; row++) {
                for (int i = 1; i <= radius; i++) {
                    //right
                    if (isValid(matrix, currentRow, currentColumn + i) && !matrix[currentRow][currentColumn + i].equals(" ")) {
                        if (isValid(matrix, currentRow, currentColumn + i))
                            matrix[currentRow][currentColumn + i] = " ";
                    }
                    //left
                    if (isValid(matrix, currentRow, currentColumn - i) && !matrix[currentRow][currentColumn - i].equals(" ")) {
                        matrix[currentRow][currentColumn - i] = " ";
                    }
                    //up
                    if (isValid(matrix, currentRow - i, currentColumn) && !matrix[currentRow - i][currentColumn].equals(" ")) {
                        matrix[currentRow - i][currentColumn] = " ";
                    }
                    //down
                    if (isValid(matrix, currentRow + i, currentColumn) && !matrix[currentRow + i][currentColumn].equals(" ")) {
                        matrix[currentRow + i][currentColumn] = " ";
                    }
                }
                matrix[currentRow][currentColumn] = " ";
            }
            for (int row = 0; row < matrix.length; row++) {
                for (int col = matrix[row].length - 1; col > 0; col--) {

                    if (!matrix[row][col].equals(" ") && matrix[row][col - 1].equals(" ")) {
                        matrix[row][col - 1] = matrix[row][col];
                        matrix[row][col] = " ";
                    }
                }
            }
            return matrixDistraction(matrix, scanner);
        }
    }
    private static boolean isValid(String[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static String[][] fillMatrix(String[] rowAndCols) {
        int rows = Integer.parseInt(rowAndCols[0]);
        int cols = Integer.parseInt(rowAndCols[1]);
        int startIndex = 1;
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = startIndex + "";
                startIndex++;
            }
        }
        return matrix;
    }

}
