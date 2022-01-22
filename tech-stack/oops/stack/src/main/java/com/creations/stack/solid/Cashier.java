package com.creations.stack.solid;

import com.creations.stack.solid.vehicles.Bike;
import com.creations.stack.solid.vehicles.Car;
import com.creations.stack.solid.vehicles.Scooter;
import com.creations.stack.solid.vehicles.Truck;

public class Cashier {
    public static void main(String[] args) {
        System.out.println(new Truck().getInsurance());
        System.out.println(new Bike().getInsurance());
        System.out.println(new Car().getInsurance());
    }
}
