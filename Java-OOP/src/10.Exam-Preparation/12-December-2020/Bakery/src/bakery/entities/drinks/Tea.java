package bakery.entities.drinks;

import static bakery.common.ExceptionMessages.INVALID_PRICE;

public class Tea extends BaseDrink {
    public static final double TEA_PRICE = 2.5;
    private double price;

    public Tea(String name, int portion, String brand) {

        super(name, portion, TEA_PRICE, brand);
    }


    @Override
    protected void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = TEA_PRICE;
    }
}
