import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = reamMatrices(scanner);
        int[][] secondMatrix = reamMatrices(scanner);

        boolean isEqual = checkEquality(firstMatrix, secondMatrix);

        System.out.println(isEqual ? "equal" : "not equal");

    }

    private static boolean checkEquality(int[][] firstMatrix, int[][] secondMatrix) {

        if (firstMatrix.length != secondMatrix.length){
            return false;
        }
        for (int i = 0; i < firstMatrix.length ; i++) {
            int[] line = firstMatrix[i];
            int[] secondLine = secondMatrix[i];
            if (line.length != secondLine.length){
               return false;
            }
            for (int j = 0; j < line.length ; j++) {
                int firstElement = line[j];
                int secondElement = secondLine[j];

                if(firstElement != secondElement){
                   return false;
                }
            }
        }
        return true;
    }

    private static int[][] reamMatrices(Scanner scanner) {
        String[] input = scanner.nextLine().split("\\s+");
        int row = Integer.parseInt(input[0]);
        int column = Integer.parseInt(input[1]);

        int[][] matrix = new int[row][column];

        for (int i = 0; i < row; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer:: parseInt).toArray();

            matrix[i] = arr;
        }
        return matrix;
    }
}
