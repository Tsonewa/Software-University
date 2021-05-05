package ShopingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
private String name;
private double money;
private List<Product> products;

public Person(String name, double money){
    this.setName(name);
    this.setMoney(money);
    this.products = new ArrayList<>();
}

    private void setMoney(double money) {
    if (money < 0){
        throw  new IllegalArgumentException(Validations.INVALID_COST);
    }
    this.money = money;
    }

    private void setName(String name) {
    if (name == null || name.trim().isEmpty()){
        throw new IllegalArgumentException(Validations.INVALID_NAME);
    }
    this.name = name;
    }

    public String getName() {
        return name;
    }
    public void buyProduct(Product product) {
        if (product.getCost() <= this.money) {
            this.products.add(product);
            money -= product.getCost();
        } else {
            throw new IllegalArgumentException(this.getName() + " can't afford " + product.getName());
        }
    }
}
