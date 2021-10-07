package bakery.entities.drinks;

import bakery.entities.drinks.interfaces.Drink;

import static bakery.common.ExceptionMessages.*;

public class BaseDrink implements Drink {
    private String name;
    private int portion;
    private double price;
    private String brand;

    protected BaseDrink(String name, int portion, double price, String brand) {
        this.setName(name);
        this.setPortion(portion);
        this.setPrice(price);
        this.setBrand(brand);
    }

    private void setBrand(String brand) {
        if(brand == null || brand.trim().isEmpty()){
            throw  new IllegalArgumentException(INVALID_BRAND);
        }
        this.brand = brand;
    }


    protected void setPrice(double price) {
        if(price <= 0){
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
    }

    private void setPortion(int portion) {

        if(portion <= 0){
            throw new IllegalArgumentException(INVALID_PORTION);
        }
        this.portion = portion;
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw  new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getPortion() {
        return this.portion;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getBrand() {
        return String.format("%s %s - %dml - %.2flv", getName(), this.brand, getPortion(), getPrice());
    }
}
