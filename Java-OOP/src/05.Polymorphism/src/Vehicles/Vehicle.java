package Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {

    private double fuelQuantity;
    private double consumption;
    private int tankCapacity;

    protected Vehicle(double fuelQuantity, double consumption, int tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.setTankCapacity(tankCapacity);
        this.consumption = consumption;
    }

    private void setTankCapacity(int tankCapacity) {
        if (this.tankCapacity < 0){
            System.out.println("Fuel must be a positive number");
        }
        this.tankCapacity = tankCapacity;
    }

    public String driving(Double distance){
       DecimalFormat formatter = new DecimalFormat("##.##");

        if(this.consumption * distance < fuelQuantity){
            this.fuelQuantity -= (consumption * distance);
            return String.format("%s travelled %s km", this.getClass().getSimpleName(), formatter.format(distance));
        } else {
            return  this.getClass().getSimpleName() + " needs refueling";
        }
   }

   public void refueling(Double liters){

        if(liters <= 0){
            System.out.println("Fuel must be a positive number");
        } else if(this.tankCapacity < this.fuelQuantity + liters){
            System.out.println("Cannot fit fuel in tank");
        } else {
            this.fuelQuantity += liters;
        }
   }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
