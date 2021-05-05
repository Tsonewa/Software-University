import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class IntersectionOfTwoMatreces {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cows = Integer.parseInt(scanner.nextLine());
        char[][] firstMatrix = readMatrix(scanner, rows,cows);
        char[][] secondMatrix = readMatrix(scanner, rows,cows);

        char[][] result = compareMtreces(firstMatrix, secondMatrix,rows, cows);

        for (int row = 0; row < rows ; row++) {
            for (int col = 0; col < cows ; col++) {
                char curr = result[row][col];
                System.out.print(curr);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static char[][] compareMtreces(char[][] firstMatrix, char[][] secondMatrix,int rows, int cols) {
        char[][] result = new char[rows][cols];

        for (int row = 0; row < rows ; row++) {
            for (int col = 0; col < cols; col++) {
                if (firstMatrix[row][col] == secondMatrix[row][col]){
                    char charecter = firstMatrix[row][col];
                    result[row][col] =  charecter;
                }else {
                    result[row][col] = '*';
                }
            }
        }
        return result;
    }

    private static char[][] readMatrix(Scanner scanner, int rows, int cows) {
        char[][] matrix = new char[rows][cows];

        for (int row = 0; row < rows ; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }

        return matrix;
    }
}
