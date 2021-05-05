import java.util.Scanner;

public class ChristmasMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        double needMoney = Double.parseDouble(scanner.nextLine());
        int sciFiBook = Integer.parseInt(scanner.nextLine());
        int horrorBook = Integer.parseInt(scanner.nextLine());
        int romanticBook = Integer.parseInt(scanner.nextLine());

        double sciFi = sciFiBook * 14.9;
        double horror = horrorBook * 9.8;
        double romantic = romanticBook * 4.3;
        double sum = sciFi + horror + romantic;
        double totalSum = sum - (sum * 0.2);

        if (totalSum > needMoney){
            double diff = totalSum - needMoney;
            double percent = diff - (Math.floor(diff * 0.1));
            double summary = diff - percent;
            double total = Math.abs(summary - totalSum);
            System.out.printf("%.2f leva donated.%n", total);
            System.out.printf("Sellers will receive %.0f leva.", summary);
        }else {
            double needMore = needMoney - totalSum;
            System.out.printf("%.2f money needed.", needMore);
        }
    }
}
