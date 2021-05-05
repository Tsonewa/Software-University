package WildFarm;

public class Tiger extends Felime {

    public Tiger(String animalName, String animalType, Double animalWeight, String animalLivingRegion) {
        super(animalName, animalType, animalWeight, animalLivingRegion);
    }

    @Override
    public void eat(Food food) {
        if(food instanceof Meat){
            setFoodEaten(food.getQuantity());
        }else {
            throw new IllegalArgumentException(getAnimalName() + "s are not eating that type of food!");
        }
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }
}
