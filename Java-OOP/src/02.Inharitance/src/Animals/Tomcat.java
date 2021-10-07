package Animals;

public class Tomcat extends Cat {
    public Tomcat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void setGender(String gender) {
        super.setGender("Male");
    }

    @Override
    public String produceSound() {
        return "MEOW";
    }
}
