package WildFarm;

public class Zebra extends Mammal {

    public Zebra(String animalName, String animalType, Double animalWeight, String animalLivingRegion) {
        super(animalName, animalType, animalWeight, animalLivingRegion);
    }

    @Override
    public void eat(Food food) {
        if(food instanceof Vegetable){
            setFoodEaten(food.getQuantity());
        }else {
            throw new IllegalArgumentException(getAnimalName() + "s are not eating that type of food!");
        }
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }
}
