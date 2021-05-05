package CarInfo;

import org.w3c.dom.ls.LSOutput;

public class Car {
  public String brand;
  public String model;
  public int horsepower;

public Car (String brand, String model, int horsepower){
    this.brand = brand;
    this.model = model;
    this.horsepower = horsepower;
}

    public int getHorsepower() {
        return horsepower;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public void setModel(String model) {
        this.model = model;
    }
    @Override
    public String toString  () {
       return String.format("The car is: %s %s - %d HP.",
                this.brand, this.model, this.horsepower);
    }


}
