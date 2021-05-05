import java.util.Scanner;

public class Charity {
    public static void main (String[] arg) {
        Scanner scanner = new Scanner(System.in);
        int daysNumber = Integer.parseInt(scanner.nextLine());
        int bakersNumber = Integer.parseInt(scanner.nextLine());
        int cakeNumber = Integer.parseInt(scanner.nextLine());
        int waferNumber = Integer.parseInt(scanner.nextLine());
        int pancakeNumber = Integer.parseInt(scanner.nextLine());
        // product price: 45/5.8/3.80
        double cake = cakeNumber * 45;
        double wafer = waferNumber * 5.8;
        double pancake = pancakeNumber * 3.20;
        // earn money: all product add bakers add days
        double profitbyone = (cake + wafer + pancake) * bakersNumber;
        double allprofit = profitbyone * daysNumber;
        double finale = allprofit * 7/8;

        System.out.printf("%.2f",finale);
    }
}
