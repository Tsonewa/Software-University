package WildFarm;

import java.text.DecimalFormat;

public abstract class Animal {

    private String animalName;
    private String animalType;
    private Double animalWeight;
    private String animalLivingRegion;
    private Integer foodEaten = 0;

    protected Animal(String animalName, String animalType, Double animalWeight, String animalLivingRegion) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.animalLivingRegion = animalLivingRegion;
    }

    public void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

    protected Double getAnimalWeight() { return this.animalWeight; }

    protected Integer getFoodEaten() {
        return this.foodEaten;
    }

    protected String getAnimalLivingRegion() {
        return this.animalLivingRegion;
    }

    protected String getAnimalName() {
        return this.animalName;
    }

    protected String getAnimalType() {
        return this.animalType;
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("#.#");
        return String.format("%s[%s, %s, %s, %d]", getAnimalName(), getAnimalType(), formatter.format(getAnimalWeight()), getAnimalLivingRegion(), getFoodEaten());
    }

    abstract public void eat(Food food);
    abstract public void makeSound();
}
