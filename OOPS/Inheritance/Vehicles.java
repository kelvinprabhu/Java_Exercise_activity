package Inheritance;

class Vehicle {
    String model;

    // public Vehicle(String model) {
    // this.model = model;
    // }

    Vehicle(String model) {
        this.model = model;
    }

    public void startEngine() {
        System.out.println("Engine started");
    }
}

class Car extends Vehicle {
    int speed;

    public Car(String model, int speed) {
        super(model);
        // model = model;

        this.speed = speed;
    }

    public void startEngine() {
        System.out.println("Car engine started");
    }

    public void drive() {
        System.out.println("Car is driving at speed: " + speed);
    }
}

public class Vehicles {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("Generic");
        vehicle.startEngine();

        Car car = new Car("Sedan", 60);
        car.startEngine();
        car.drive();
    }
}
