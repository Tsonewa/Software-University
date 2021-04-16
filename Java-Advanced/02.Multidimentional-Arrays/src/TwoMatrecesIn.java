import java.util.Scanner;

public class TwoMatrecesIn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = Integer.parseInt(scanner.nextLine());
        int column = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = ReadCharecterMatrix(scanner, row, column);
        char[][] secondMatrix = ReadCharecterMatrix(scanner, row, column);

        char[][] result = new char[row][column];
        for (int i = 0; i < firstMatrix.length ; i++) {
            char[] line = firstMatrix[i];
            for (int j = 0; j < line.length ; j++) {
                char currFirstMatrix = firstMatrix[i][j];
                char currSecondMatrix = secondMatrix[i][j];
                if (currFirstMatrix == currSecondMatrix){
                    result[i][j] = currFirstMatrix;
                }else {
                    result[i][j] = '*';
                }
            }
        }
        for (int m = 0; m < result.length ; m++) {
            char[] digits = result[m];
            for (int n = 0; n < digits.length ; n++) {
                char digit = digits[n];
                System.out.printf("%c" + " ", digit);
            }
            System.out.println();
        }

    }

    private static char[][] ReadCharecterMatrix(Scanner scanner, int row, int column) {
        char[][] matrix = new char[row][column];


        for (int m = 0; m < matrix.length ; m++) {
            String[] lines = scanner.nextLine().split("\\s+");
            for (int n = 0; n < lines.length; n++) {
                matrix[m][n] = lines[n].charAt(0);
            }
        }
        return matrix;
    }
}
