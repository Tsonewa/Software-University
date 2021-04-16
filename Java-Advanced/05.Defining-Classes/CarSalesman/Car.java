package CarSalesman;

public class Car {
    //model, engine, weight and color
private String carModel;
private String engineModel;
private int weight;
private String color;

    public String getEngineModel() {
        return engineModel;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    //FordFocus V4-33 // optional 1300 Silver
    public Car (String carModel, String engineModel){
        this.carModel = carModel;
        this.engineModel = engineModel;
        this.color = "n/a";
        this.weight = 0;
    }
    public Car (String carModel, String engineModel, int weight){
        this(carModel, engineModel);
        this.weight = weight;
        this.color = "n/a";
    }
    public Car (String carModel, String engineModel, String color){
        this(carModel, engineModel);
        this.color = color;
    }
    public Car (String carModel, String engineModel, int weight, String color) {
        this(carModel, engineModel, color);
        this.weight = weight;
    }
}
