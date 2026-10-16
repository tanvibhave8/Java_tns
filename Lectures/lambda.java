package Lectures;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.Predicate.*;

// interface Greeter{
//     void greet(String name);
// }
public class lambda {

     public static void main(String[] args){
//         Greeter g = name -> System.out.println("Hello, " + name);
//         g.greet("Tanvi");

    Predicate<Integer>isAdult=age -> age>=18;
       System.out.println(isAdult.test(20));
       System.out.println(isAdult.test(15));
     }
}

