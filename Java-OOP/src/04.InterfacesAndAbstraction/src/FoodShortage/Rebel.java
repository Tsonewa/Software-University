package FoodShortage;

public class Rebel extends BaseBuyer {
    private String group;
    private int food;

    public Rebel(String name, int age, String group) {
        super(name, age);
        this.group = group;
    }

    @Override
    public void buyFood(){
        this.food += 5;
    }


    @Override
    public int getFood() {
        return this.food;
    }
}
