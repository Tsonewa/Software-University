import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int raws = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] matrix = readMatrix(scanner, raws,cols);
        int digit = Integer.parseInt(scanner.nextLine());

        int count = 0;

        for (int raw = 0; raw < raws; raw++)
            for (int col = 0; col < cols; col++) {
                int currentNumber = matrix[raw][col];
                if (currentNumber == digit){
                    System.out.println(raw + " " + col);
                    count++;
                }
            }
        if (count == 0){
            System.out.println("not found");
        }

    }
    public static int[][] readMatrix (Scanner scanner, int raws, int cols){

        int[][] matrex = new int[raws][cols];

        for (int raw = 0; raw < raws ; raw++) {
            matrex[raw] = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrex;
    }
}
