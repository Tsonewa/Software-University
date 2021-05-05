package BorderControl;

public class Robot extends Identified{
private String model;

public Robot(String model, String id){
super(id);
    this.model = model;
}

    public String getModel() {
        return this.model;
    }
}
