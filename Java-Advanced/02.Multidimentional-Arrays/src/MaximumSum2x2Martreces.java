import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum2x2Martreces {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int raws = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] matrix = readMatrix(scanner, raws,cols);
        int[][] submatrix = findSubmatrix(matrix, raws, cols);
        int sum = subMatrixElements(submatrix);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(submatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(sum);
    }

    private static int subMatrixElements(int[][] submatrix) {
int sum = 0;
        for (int i = 0; i < 2 ; i++) {
            for (int j = 0; j < 2 ; j++) {
                sum += submatrix[i][j];
            }
        }
        return sum;
    }

    private static int[][] findSubmatrix(int[][] matrix, int raws, int cols) {
        int[][] result = new int[2][2];
        int maxSum = Integer.MIN_VALUE;

        for (int row = 0; row < raws - 1; row++) {
            for (int col = 0; col < cols - 1  ; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (currentSum > maxSum){
                    maxSum = currentSum;
             result[0][0] = matrix[row][col];
                     result[0][1] =  matrix[row][col + 1];
                             result[1][0] = matrix[row + 1][col];
                                     result[1][1] = matrix[row + 1][col + 1];
                }
            }
        }


        return  result;
    }

    public static int[][] readMatrix (Scanner scanner, int raws, int cols){

        int[][] matrex = new int[raws][cols];

        for (int raw = 0; raw < raws ; raw++) {
            matrex[raw] = Arrays.stream(scanner.nextLine()
                    .split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrex;
    }
}
