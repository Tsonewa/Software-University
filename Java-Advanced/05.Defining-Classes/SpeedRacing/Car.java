package SpeedRacing;

public class Car {
    //Model, fuel amount, fuel
    private String model;
    private double fuelTank;
    private double fuelPerKm;
    private int travelKilometers;

public Car(String model, double fuelTank, double fuelPerKm){
    this.model = model;
    this.fuelTank = fuelTank;
    this.fuelPerKm = fuelPerKm;
    this.travelKilometers = 0;
}

    public double getFuelPerKm() {
        return fuelPerKm;
    }

    public void setFuelPerKm(double fuelPerKm) {
        this.fuelPerKm = fuelPerKm;
    }

    public boolean drive(int distanceToDrive) {
        double fuelNeeded = distanceToDrive * this.fuelPerKm;
        if (this.fuelTank >= fuelNeeded){
            this.fuelTank -= fuelNeeded;
            this.travelKilometers += distanceToDrive;
            return  true;
        }
        return false;
    }
    @Override
    public String toString (){
    return String.format("%s %.2f %d", this.model, this.fuelTank, this.travelKilometers);
    }
}
