package PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaInfo = scanner.nextLine().split("\\s+");
        Pizza pizza = null;
        try {
           pizza = new Pizza(pizzaInfo[1], Integer.parseInt(pizzaInfo[2]));
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            return;
        }

            String[] doughInfo = scanner.nextLine().split("\\s+");
            try {
                Dough dough = new Dough(doughInfo[1], doughInfo[2], Double.parseDouble(doughInfo[3]));
                pizza.setDough(dough);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                return;
            }

            String toppings = scanner.nextLine();

            while (!toppings.equals("END")) {

                String[] tokans = toppings.split("\\s+");
                try {
                    Topping topping = new Topping(tokans[1], Double.parseDouble(tokans[2]));
                    pizza.addTopping(topping);
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                    return;
                }

                toppings = scanner.nextLine();
            }
            System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
}
}
