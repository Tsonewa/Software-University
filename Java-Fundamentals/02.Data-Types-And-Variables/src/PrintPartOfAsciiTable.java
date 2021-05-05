import java.util.Scanner;

public class PrintPartOfAsciiTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        for (int i = start; i <= end; i++) {
            char symbol = (char)i;
            System.out.print(symbol + " ");
        }
    }
}
