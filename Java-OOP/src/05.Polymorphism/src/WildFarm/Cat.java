package WildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight,String animalLivingRegion, String breed) {
        super(animalName, animalType, animalWeight, animalLivingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("#.#");
        return String.format("%s[%s, %s, %s, %s, %d]",super.getAnimalName(), super.getAnimalType(), this.breed, formatter.format(getAnimalWeight()), super.getAnimalLivingRegion(), super.getFoodEaten());
    }

    @Override
    public void eat(Food food) {
        setFoodEaten(food.getQuantity());
    }
}
