package ShopingSpree;

public class Product {
    //Validation = Name cannot be an empty && Cost cannot be a negative number
    private String name;
    private double cost;

    public Product(String name, double cost){
        this.setName(name);
        this.setCost(cost);
    }

    private void setCost(double cost) {
        if (cost < 0){
            throw  new IllegalArgumentException(Validations.INVALID_COST);
        }
        this.cost = cost;
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

    public double getCost() {
        return cost;
    }

}
