import java.util.Scanner;

public class MoneyConverter {
    public static void main (String[] arg){
        Scanner scanner = new Scanner(System.in);
        // 1 USD = 1.79549 %.2f USD - BG
        double USD = Double.parseDouble(scanner.nextLine());
        double BG = USD * 1.79549;

        System.out.printf("%.2f", BG);
    }

}
