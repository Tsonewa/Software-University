package Vehicles;

public class Bus extends Vehicle {
    private static final double AIR_CONDITION_ADDITIONAL_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double consumption, int tankCapacity) {
        super(fuelQuantity, consumption + AIR_CONDITION_ADDITIONAL_CONSUMPTION, tankCapacity);
    }

}
