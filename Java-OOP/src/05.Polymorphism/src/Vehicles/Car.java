package Vehicles;

import Vehicles.Vehicle;

public class Car extends Vehicle {
    private static final double AIR_CONDITION_ADDITIONAL_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double consumption,int tankCapacity ) {
        super(fuelQuantity, consumption + AIR_CONDITION_ADDITIONAL_CONSUMPTION, tankCapacity);
    }
}
