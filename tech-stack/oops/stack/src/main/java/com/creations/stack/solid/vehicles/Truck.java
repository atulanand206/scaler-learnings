package com.creations.stack.solid.vehicles;

public class Truck extends Vehicle {
    public Truck() {
        super(VehicleType.TRUCK);
    }

    @Override
    public double getInsurance() {
        return 300;
    }
}
