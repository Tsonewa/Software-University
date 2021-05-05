import java.util.Arrays;
import java.util.Scanner;

public class CompareMatreces {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix= readMatrix(scanner);

       boolean isEqual = isEqual(firstMatrix,secondMatrix);

        System.out.print(isEqual ? "equal" : "not equal");
    }

    private static boolean isEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length || firstMatrix[0].length != secondMatrix[0].length){
            return false;
        }
        for (int rows = 0; rows < firstMatrix.length ; rows++) {
            for (int cols = 0; cols < firstMatrix[rows].length ; cols++) {
                if (firstMatrix[rows][cols] != secondMatrix[rows][cols]){
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] readMatrix (Scanner scanner){
        String[] input = scanner.nextLine().split("\\s+");
        int raws = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] matrex = new int[raws][cols];

        for (int raw = 0; raw < raws ; raw++) {
            matrex[0] = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrex;
    }
}
