import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalidrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer:: parseInt).toArray();
            int rows = input[0];
            int cols = input[1];

            String[][] matrix = new String[rows][cols];
            char startLetter = 'a';

        for (int row = 0; row < rows ; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] =  "" + startLetter + (char)(startLetter + col) + startLetter;
            }
            startLetter = (char)(startLetter + 1);
        }
        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
