import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonals {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        for (int raw = 0; raw < n; raw++) {
            matrix[raw] = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        for (int row = 0; row < n ; row++) {
                System.out.print(matrix[row][row] + " ");
        }
        System.out.println();

        for (int row = 0; row < n ; row++) {
            System.out.print(matrix[(n - 1) - row][row] + " ");
        }
    }
}
