package WildFarm;

public class Mouse extends Mammal {

    public Mouse(String animalName, String animalType, Double animalWeight, String animalLivingRegion) {
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
        System.out.println("SQUEEEAAAK!");
    }
}
