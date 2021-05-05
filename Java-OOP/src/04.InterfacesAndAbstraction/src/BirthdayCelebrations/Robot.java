package BirthdayCelebrations;

public class Robot implements Birthable, Identifiable {
    private String model;
    private String id;

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    @Override
    public String getBirthDate() {
        return this.model;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
