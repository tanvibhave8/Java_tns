package oops;

// Compile-time Polymorphism
class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    // Same method name, three parameters
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // Same method name, different parameter types
    double add(double a, double b) {
        return a + b;
    }
}

// Runtime Polymorphism
class Animal {

    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {

    @Override
    void makeSound() {
        System.out.println("Dog barks: Woof woof!");
    }
}

// Main class
public class polymorphism {

    public static void main(String[] args) {

        // Compile-time polymorphism
        Calculator calc = new Calculator();

        System.out.println("Addition of 2 numbers: " + calc.add(10, 20));
        System.out.println("Addition of 3 numbers: " + calc.add(10, 20, 30));
        System.out.println("Addition of double values: " + calc.add(10.5, 20.5));

        // Runtime polymorphism
        Animal animal = new Dog();
        animal.makeSound();
    }
}