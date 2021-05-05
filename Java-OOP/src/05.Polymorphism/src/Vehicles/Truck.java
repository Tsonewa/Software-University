package Vehicles;

import Vehicles.Vehicle;

public class Truck extends Vehicle {
    private static final double AIR_CONDITION_ADDITIONAL_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double consumption, int tankCapacity) {
        super(fuelQuantity, consumption + AIR_CONDITION_ADDITIONAL_CONSUMPTION, tankCapacity);
    }


    @Override
    public void refueling(Double liters) {
        super.refueling(95 * liters / 100);
    }
}
