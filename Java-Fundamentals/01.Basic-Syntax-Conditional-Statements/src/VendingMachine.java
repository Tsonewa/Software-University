import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input

        String input = scanner.nextLine();
        double money = 0.0;

        while (!input.equals("Start")){
            //0.1, 0.2, 0.5, 1, and 2 coins
            double coin = Double.valueOf(input);
            if (coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1.0 || coin == 2.0 ) {
                money += coin;
            }else {
                System.out.printf("Cannon accept %.2f%n", coin);
            }
            input = scanner.nextLine();
        }
        String product = scanner.nextLine();
        double change = money;
        while (!product.equals("End")){
            double minusOneproduct = 0;
            //Nuts", "Water", "Crisps", "Soda", "Coke".
            //The prices are: 2.0, 0.7, 1.5, 0.8, 1.0 respectively.
            // If the person tries to purchase a not existing product print “Invalid product”.
            // If he doesn't have enough money. In that case print "Sorry, not enough money".
            // If the person purchases a product successfully print "Purchased {product name}".
            switch (product){
                case "Nuts":
                    if (change >= 2.0) {
                        minusOneproduct += 2.0;
                        change -= minusOneproduct;
                        System.out.printf("Purchased %s%n", product);
                    }else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Water":
                    if (change >= 0.7) {
                        minusOneproduct += 0.7;
                        change -= minusOneproduct;
                        System.out.printf("Purchased %s%n", product);
                    }else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Crisps":
                    if (change >= 1.5) {
                        minusOneproduct += 1.5;
                        change -= minusOneproduct;
                        System.out.printf("Purchased %s%n", product);
                    }else{
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Soda":
                    if (change >= 0.8) {
                        minusOneproduct += 0.8;
                        change -= minusOneproduct;
                        System.out.printf("Purchased %s%n", product);
                    }else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Coke":
                    if (change >= 1.0) {
                        minusOneproduct += 1.0;
                        change -= minusOneproduct;
                        System.out.printf("Purchased %s%n", product);
                    }else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                default:
                    System.out.println("Invalid product");
            }
            product = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", change);
    }
}
