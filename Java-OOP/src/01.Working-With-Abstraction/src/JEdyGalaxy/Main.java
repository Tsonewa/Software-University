package JEdyGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] size = scanner.nextLine().split(" ");
        int row = Integer.parseInt(size[0]);
        int col = Integer.parseInt(size[1]);

        int[][] matrix = fillMatrix(row, col);

        String command = scanner.nextLine();
        long sum = 0;

        while (!command.equals("Let the Force be with you")) {
            int[] playerCoordinates = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilNumberPosition = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int playerRow = playerCoordinates[0];
            int playerCol = playerCoordinates[1];
            int evilNumberRow = evilNumberPosition[0];
            int evilNumberCol = evilNumberPosition[1];

            removeValues(matrix, evilNumberRow, evilNumberCol);
            sum = getSum(matrix, sum, playerRow, playerCol);

            command = scanner.nextLine();
        }
        System.out.println(sum);
    }

    private static long getSum(int[][] matrix, long sum, int playerRow, int playerCol) {
        while (playerRow >= 0 && playerCol < matrix[1].length) {
            if (isValid(playerRow, playerCol, matrix)) {
                sum += matrix[playerRow][playerCol];
            }
            playerRow--;
            playerCol++;
        }
        return sum;
    }

    private static void removeValues(int[][] matrix, int evilNumberRow, int evilNumberCol) {
        while (evilNumberRow >= 0 && evilNumberCol >= 0) {
            if (isValid(evilNumberRow, evilNumberCol, matrix)) {
                matrix[evilNumberRow] [evilNumberCol] = 0;
            }
            evilNumberRow--;
            evilNumberCol--;
        }
    }

    private static boolean isValid(int evilNumberRow, int evilNumberCol, int[][] matrix) {
        return evilNumberRow >= 0 && evilNumberRow < matrix.length && evilNumberCol >= 0 && evilNumberCol < matrix[0].length;
    }

    private static int[][] fillMatrix(int row, int col) {
        int[][] matrix = new int[row][col];
        int value = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = value++;
            }
        }
        return matrix;
    }
    }