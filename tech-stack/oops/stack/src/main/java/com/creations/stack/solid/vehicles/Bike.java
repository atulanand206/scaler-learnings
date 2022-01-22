package com.creations.stack.solid.vehicles;

public class Bike extends Vehicle {
    public Bike() {
        super(VehicleType.BIKE);
    }

    @Override
    public double getInsurance() {
        return 150;
    }
}
