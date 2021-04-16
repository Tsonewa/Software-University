import com.sun.source.tree.IfTree;

import java.util.Scanner;

public class CakeExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int cakeH = Integer.parseInt(scanner.nextLine());
        int cakeW = Integer.parseInt(scanner.nextLine());
        int numberOfPieces = cakeH * cakeW;
        String input = scanner.nextLine();

        while (!input.equals("STOP")) {
            int piece = Integer.parseInt(input);
            numberOfPieces -= piece;

            if (numberOfPieces < 0) {
                System.out.printf("No more cake left! You need %d pieces more.", Math.abs(numberOfPieces));
                break;
            }
            input = scanner.nextLine();
        }
        if (numberOfPieces > 0) {
            System.out.printf("%d pieces are left.", numberOfPieces);
        }
    }
}