package ProblemSets;
import java.util.*;

public class exceptionHandling {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println();

        int num1=sc.nextInt();
        int num2=sc.nextInt();

        try{
            int result= num1/num2;
            System.out.println("REsult :" + result);
        }catch (ArithmeticException e){
            System.out.println("Error: Cannot divide by zero.");
        }
    }
}
