import java.util.Scanner;

public class FoodOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        double budget = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        int countItem = 0;
        double order = 2.5;

        while(!input.equals("Order")){
            double price = Double.parseDouble(scanner.nextLine());
                order += price;
                countItem++;
            if (budget < order){
                System.out.printf("You will exceed the budget if you order this!%n");
                order -= price;
                countItem--;

            }
            input = scanner.nextLine();
        }

        System.out.printf("You ordered %d items!%n",countItem);
        System.out.printf("Total: %.2f",order);
    }
}
