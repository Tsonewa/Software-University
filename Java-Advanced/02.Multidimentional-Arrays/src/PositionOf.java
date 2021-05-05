import java.util.Arrays;
import java.util.Scanner;

public class PositionOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int row = Integer.parseInt(input[0]);
        int column = Integer.parseInt(input[1]);

        int[][] matrix = new int[row][column];

        for (int i = 0; i < row ; i++) {
            int[] matrixSize = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = matrixSize;
        }
        int digit = Integer.parseInt(scanner.nextLine());

        boolean exist = false;

        for (int i = 0; i < matrix.length; i++) {
            int[] matrixRow = matrix[i];
            for (int j = 0; j < matrixRow.length ; j++) {
                int currDigit = matrixRow[j];

                if (currDigit == digit){
                    exist = true;
                    System.out.println(i + " " + j);
                }
            }
        }
            if (!exist){
                System.out.println("not found");
            }
    }
}
