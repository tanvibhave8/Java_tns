package ProblemSets;


class Vehicle {
    String registrationNumber;

    Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    double calculateToll() {
        return 50.0;
    }
}

class Car extends Vehicle {

    Car(String registrationNumber) {
        super(registrationNumber);
    }

    @Override
    double calculateToll() {
        return 50.0 + 20.0;
    }
}

class Truck extends Vehicle {
    int axles;

    Truck(String registrationNumber, int axles) {
        super(registrationNumber);
        this.axles = axles;
    }

    @Override
    double calculateToll() {
        return 100.0 + (50.0 * axles);
    }
}

public class VehicleToll {
    public static void main(String[] args) {

        Vehicle v1 = new Car("MH05AB1234");
        Vehicle v2 = new Truck("MH04CD5678", 4);

        System.out.println("Car Toll: Rs. " + v1.calculateToll());
        System.out.println("Truck Toll: Rs. " + v2.calculateToll());
    }
}
