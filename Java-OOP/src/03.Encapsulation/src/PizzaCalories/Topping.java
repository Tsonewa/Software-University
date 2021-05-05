package PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight){
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setWeight(double weight) {
        if (weight < 0 || weight > 50){
            throw  new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public String getToppingType() {
        return toppingType;
    }

    private void setToppingType(String toppingType) {
            if (!ToppingModifiers.CHEESE.name().toUpperCase().equals(toppingType.toUpperCase())
            && !ToppingModifiers.MEAT.name().equals(toppingType.toUpperCase())
            && !ToppingModifiers.SAUCE.name().equals(toppingType.toUpperCase())
            && !ToppingModifiers.VEGGIES.name().equals(toppingType.toUpperCase())){
                throw  new IllegalArgumentException("Cannot place " + toppingType +  " on top of your pizza.");
            }
                this.toppingType = toppingType;
    }
public double calculateCalories (){
        return (2 * this.weight) * ToppingModifiers.valueOf(this.toppingType.toUpperCase()).getValue();
}
}
