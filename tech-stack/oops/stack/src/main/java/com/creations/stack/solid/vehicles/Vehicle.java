package com.creations.stack.solid.vehicles;

public class Vehicle {
    private final VehicleType type;

    public Vehicle(VehicleType type) {
        this.type = type;
    }

    public double getInsurance() {
        return 100;
    }
}
