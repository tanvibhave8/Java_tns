package inheritance;


//Simple Inheritance
class Animal{
    void eat(){
        System.out.println("This animal eats food.");
    }
}

class Dog extends Animal{
    void bark(){
        System.out.println("The dog barks.");
    }
}

public class simple_inheritance {
    public static void main(String[] args) {
        Dog mydog=new Dog();
        mydog.eat();
        mydog.bark();
    }
}
