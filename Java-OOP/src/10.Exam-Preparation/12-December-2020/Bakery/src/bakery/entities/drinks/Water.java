package bakery.entities.drinks;

import static bakery.common.ExceptionMessages.INVALID_PRICE;

public class Water extends BaseDrink {

    public static final double WATER_PRICE = 1.5;
    private double price;

    public Water(String name, int portion, String brand) {
        super(name, portion, WATER_PRICE, brand);
    }

    @Override
    protected void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = WATER_PRICE;
    }
}
