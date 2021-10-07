package Animals;

public class Dog extends Animal {

    protected Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("I am Rocky and my favourite food is Meat \nDJAAF", super.getName(), super.getFavouriteFood());
    }
}
