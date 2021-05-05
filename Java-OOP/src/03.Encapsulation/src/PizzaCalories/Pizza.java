package PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
private String name;
private Dough dough;
private List<Topping> toppings;

public  Pizza (String name, int numberOfToppings){
    this.setName(name);
    this.setToppings(numberOfToppings);
}

    private void setName(String name) {
    if (name.trim().isEmpty() || name.trim().length() > 15){
        throw  new IllegalArgumentException(DataValidations.INVALID_PIZZA_NAME);
    }
    this.name = name;
    }

    private void setToppings(int numberOfToppings){
    if (numberOfToppings < 1 || numberOfToppings > 10) {
    throw  new IllegalArgumentException(DataValidations.TOPPINGS_OUT_OF_RANGE);
}
    this.toppings = new ArrayList<>();
}

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }

    public void addTopping(Topping topping){
    this.toppings.add(topping);
    }

public double getOverallCalories(){
    return this.dough.calculateCalories() + this.toppings.stream().mapToDouble(Topping::calculateCalories).sum();
}
}
