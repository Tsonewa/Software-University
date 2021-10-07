package BorderControl;

public class Citizen extends Identified {
    private String name;
    private int age;

    public Citizen(String name, int age, String id){
        super(id);
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }
}
