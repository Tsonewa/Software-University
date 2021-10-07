package NeedForSpeed;

public class Vehicle {

    public final static double DEFAULT_FUEL_CONSUMPTION = 1.25;

    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle(double fuel, int horsePower){
        setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
        setFuel(fuel);
        setHorsePower(horsePower);
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public double getFuel() {
        return fuel;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void drive(double kilometers){
        double neededFuel = this.fuelConsumption * kilometers;

        if(this.getFuel() >= neededFuel){
            setFuel(this.getFuel() - neededFuel);

        }
        }
    }
