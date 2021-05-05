import java.util.Scanner;

public class PoundsToDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        //1 British Pound = 1.31 Dollars
        double britishPound = Double.parseDouble(scanner.nextLine());

        double total = britishPound * 1.31;
        System.out.printf("%.3f", total);
    }
}
