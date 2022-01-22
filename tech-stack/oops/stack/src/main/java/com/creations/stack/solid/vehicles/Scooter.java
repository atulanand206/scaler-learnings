package com.creations.stack.solid.vehicles;

public class Scooter extends Vehicle {
    public Scooter() {
        super(VehicleType.SCOOTER);
    }

    @Override
    public double getInsurance() {
        return 75;
    }
}
