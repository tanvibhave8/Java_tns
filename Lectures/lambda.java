package Lectures;


interface Greeter{
    void greet(String name);
}
public class lambda {

    public static void main(String[] args){
        Greeter g = name -> System.out.println("Hello, " + name);
        g.greet("Tanvi");
    }
}