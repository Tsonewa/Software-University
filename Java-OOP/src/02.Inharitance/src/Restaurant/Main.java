package Restaurant;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
Coffee coffee = new Coffee("Lavazza", 50);
        System.out.println(coffee.getName());
        System.out.println(coffee.getPrice());
        System.out.println(coffee.getMilliliters());
        System.out.println(coffee.getCaffeine());
    }
}
