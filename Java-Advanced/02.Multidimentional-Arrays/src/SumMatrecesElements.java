import java.util.Arrays;
import java.util.Scanner;

public class SumMatrecesElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int raws = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] matrix = readMatrix(scanner,raws,cols);

        int sum = 0;

        for (int row = 0; row < raws ; row++) {
            for (int col = 0; col <cols ; col++) {
                int currentDigit = matrix[row][col];
                sum += currentDigit;
            }
        }
        System.out.println(raws);
        System.out.println(cols);
        System.out.println(sum);

    }
    public static int[][] readMatrix (Scanner scanner, int rows,int cols){

        int[][] matrex = new int[rows][cols];

        for (int raw = 0; raw < rows ; raw++) {
            matrex[raw] = Arrays.stream(scanner.nextLine()
                    .split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrex;
    }
}
