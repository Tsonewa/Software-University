import java.util.Scanner;

public class Orders {

    public static void priceCoffee(int amount){
        double totalPrice = amount * 1.50;
        System.out.printf("%.2f", totalPrice);
    }
    public static void priceWater(int amount){
        double totalPrice = amount * 1.00;
        System.out.printf("%.2f", totalPrice);
    }
    public static void priceCoke(int amount){
        double totalPrice = amount * 1.40;
        System.out.printf("%.2f", totalPrice);
    }
    public static void priceSnacks(int amount){
        double totalPrice = amount * 2.00;
        System.out.printf("%.2f", totalPrice);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        Write a method that calculates the total price of an order and prints it on the console.
         The method should receive -> coffee, water, coke, snacks; and a quantity of the product.
         The prices for a single product are:
         coffee – 1.50 / water – 1.00 / coke – 1.40 /snacks – 2.00
         Print the result rounded to the second decimal place.
         */
        String product = scanner.nextLine();
        int amount = Integer.parseInt(scanner.nextLine());
        switch (product){
            case "coffee":
                priceCoffee(amount);
                break;
            case "water":
                priceWater(amount);
                break;
            case "coke":
                priceCoke(amount);
                break;
            case "snacks":
                priceSnacks(amount);
        }
    }
}