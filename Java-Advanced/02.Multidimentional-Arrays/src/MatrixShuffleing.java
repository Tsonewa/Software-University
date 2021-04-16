import java.util.Scanner;

public class MatrixShuffleing {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows ; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
        String input = scanner.nextLine();

        while (!input.equals("END")){
            String[] cordinates = input.split("\\s+");

             if (cordinates.length > 5){
                System.out.println("Invalid input!");
            } else if (cordinates[0].equals("swap")) {
                printSwapedMatrix(matrix, cordinates);
            }else {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine();
        }
    }

    private static void printSwapedMatrix(String[][] matrix, String[] cordinates) {
        int row1 = Integer.parseInt(cordinates[1]);
        int col1 = Integer.parseInt(cordinates[2]);
        int row2 = Integer.parseInt(cordinates[3]);
        int col2 = Integer.parseInt(cordinates[4]);
        boolean areValid = checkIndexesValidy(matrix, row1, col1, row2, col2);
        String[][] swapedMatrix = matrix;

            if (areValid) {
                String firstDigit = matrix[row1][col1];
                String secondDigit = matrix[row2][col2];
                swapedMatrix[row1][col1] = secondDigit + "";
                swapedMatrix[row2][col2] = firstDigit + "";
                for (String[] swapedMatrix1 : swapedMatrix) {
                    for (String s : swapedMatrix1) {
                        System.out.print(s + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Invalid input!");
            }
    }
    private static boolean checkIndexesValidy(String[][] matrix, int row1, int col1, int row2, int col2) {
        return row1 <= matrix.length && row2 <= matrix.length && col1 <= matrix[0].length && col2 <= matrix[row1].length;
    }
}
