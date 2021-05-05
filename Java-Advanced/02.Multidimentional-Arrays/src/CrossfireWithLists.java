import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CrossfireWithLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] data = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = data[0];
        int cols = data[1];
        int sequentNumber = 1;


        ArrayList<ArrayList<Integer>> matrixList = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            ArrayList<Integer> rowList = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                rowList.add(sequentNumber);
                sequentNumber++;
            }
            matrixList.add(rowList);
        }
        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            String[] tokens = command.split(" ");
            int rowIndex = Integer.parseInt(tokens[0]);
            int colIndex = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);


            for (int row = rowIndex - radius; row <= rowIndex + radius; row++) {
                if ((row >= 0 && row < matrixList.size()) && (colIndex >= 0 && colIndex < matrixList.get(row).size())) {
                    matrixList.get(row).set(colIndex, 0);
                }
            }
            for (int col = colIndex - radius; col <= colIndex + radius; col++) {
                if (rowIndex >= 0 && rowIndex < matrixList.size() && col >= 0 && col < matrixList.get(rowIndex).size()) {
                    matrixList.get(rowIndex).set(col, 0);
                }
            }
            for (int i = 0; i < matrixList.size(); i++) {
                matrixList.get(i).removeAll(new ArrayList<Integer>() {{
                    add(0);
                }});

                if (matrixList.get(i).size() == 0) {
                    matrixList.remove(i);
                    i--;
                }
            }
            command = scanner.nextLine();
        }

        for (ArrayList<Integer> integers : matrixList) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}