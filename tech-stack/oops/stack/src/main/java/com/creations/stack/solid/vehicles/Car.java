package com.creations.stack.solid.vehicles;

public class Car extends Vehicle {
    public Car() {
        super(VehicleType.CAR);
    }

    @Override
    public double getInsurance() {
        return 200;
    }
}
