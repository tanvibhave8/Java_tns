package oops;
// Parent Class (Superclass)
class Vehicle {

    // Attribute
    String brand;

    // Method
    void startEngine() {
        System.out.println(brand + " engine started.");
    }
}

// Child Class (Subclass) inherits from Vehicle
class Bike extends Vehicle {

    boolean hasCarrier;

    void kickStand() {
        System.out.println("Kickstand put down.");
    }
}

// Main Class
public class inheri {

    public static void main(String[] args) {

        Bike myBike = new Bike();

        myBike.brand = "Shine";       // Inherited from Vehicle
        myBike.startEngine();         // Inherited from Vehicle
        myBike.kickStand();           // Bike's own method
    }
}