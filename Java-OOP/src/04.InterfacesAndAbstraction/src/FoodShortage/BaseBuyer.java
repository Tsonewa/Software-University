package FoodShortage;

public class BaseBuyer implements Person, Buyer {

    private String name;
    private int age;
    private int food;

    public BaseBuyer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void buyFood() {
        this.food = 0;
    }

    @Override
    public int getFood() {
        return this.food;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }
}
