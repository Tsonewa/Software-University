import java.util.Scanner;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        String kindSweets = scanner.nextLine(); //“Cake”, “Souffle” или “Baklava”
        int countSweets = Integer.parseInt(scanner.nextLine());
        int day = Integer.parseInt(scanner.nextLine());
        double price = 0;

        switch (kindSweets){
            case "Cake":
                if (day <= 15){
                    price += 24 * countSweets;
                }else {
                    price += 28.7 * countSweets;
                }
                break;
            case "Souffle":
                if (day <= 15){
                    price += 6.66 * countSweets;
                }else {
                    price += 9.80 *countSweets;
                }
                break;
            case "Baklava":
                if (day <= 15){
                    price += 12.60 * countSweets;
                }else {
                    price += 16.98 * countSweets;
                }
                break;
        }
        if (price >= 100 && price <= 200 && day >= 1 && day <= 22){
            price -= (price * 0.15);
        }else if (price > 200 && day >= 1 && day <= 22){
            price -= (price * 0.25);
        }
        if (day >= 1 && day <= 15){
            double discount = price - (price * 0.1);
            System.out.printf("%.2f", discount);
        }else {
            System.out.printf("%.2f", price);
        }

    }
}
