import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMesurments {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(scanner, size);
        int[] indexes = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray(); // row and col
        int replace = matrix[indexes[0]][indexes[1]];
        List<int[]> indexReplace = new ArrayList<>();
        List<Integer> correctValues = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++)
            for (int col = 0; col < matrix[row].length; col++) {
                int currentIndex = matrix[row][col];
                if (currentIndex == replace) {
                    indexReplace.add(new int[]{row, col});
                    correctValues.add(getCorrectValue(matrix, row, col));
                }
            }
        for (int i = 0; i < indexReplace.size() ; i++) {
            int[] roesAndCols = indexReplace.get(i);
            matrix[roesAndCols[0]][roesAndCols[1]] = correctValues.get(i);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int getCorrectValue(int[][] matrix, int row, int col) {
        int sum = 0;
        int wrongNumber = matrix[row][col];

        if (inBounds(matrix, row - 1, col) && matrix[row - 1][col] != wrongNumber)
            sum += matrix[row - 1][col];

    if(inBounds(matrix, row, col + 1) && matrix[row][col + 1] != wrongNumber)
    sum += matrix[row ][col + 1];

    if(inBounds(matrix, row, col  - 1)  && matrix[row][col - 1] != wrongNumber)
    sum += matrix[row ][col - 1];

    if (inBounds(matrix , row + 1,col)  && matrix[row + 1][col] != wrongNumber)
            sum += matrix[row + 1][col];

    return sum;
}
    private static boolean inBounds(int[][] matrix, int row,int col) {
        return  (row >= 0 && row < matrix.length  && col >= 0 && col < matrix[row].length );
    }

    public static int[][] readMatrix (Scanner scanner, int size){

        int[][] matrex = new int[size][size];

        for (int raw = 0; raw < size ; raw++) {
            matrex[raw] = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrex;
    }
}
