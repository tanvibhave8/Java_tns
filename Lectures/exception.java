package Lectures;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class exception {
 public static void main(String[] args) {

        // //Arithematic Exception
        // int a =10/0;
        // int b=0;

        // try{
        //     int rest = a/b;
        //     System.out.println(rest);
        //  }catch(ArithmeticException e){
        //     System.out.println("You cannot divide by 0.");
        //     System.out.println("The error type was :" + e.getMessage());
        //  }
//------------------------------------------------------------------------------------
    // try {
    //     // int res=10/0;
    //     // System.out.println(res);
    //     int[] numbers={10,20,30};
    //     System.out.println(numbers[5]);
    //     } catch (ArrayIndexOutOfBoundsException e){
    //         System.out.println("Invalid array index.");
    //     }catch(ArithmeticException e){
    //         System.out.println("Cannot be divided by 0.");
    //     }

//------------------------------------------------------------------------------
    //finally:closing statement.

    // try{
    //     int res=10/5;
    // }catch(ArithmeticException e){
    //     System.out.println("Cannot divide by 0.");
    // }finally{
    //     System.out.println("Finally block executed");
    // } 

//--------------------------------throw-----------------------------------
// System.out.print("Enter age : ");  
// Scanner sc=new Scanner(System.in);

//    int age =sc.nextInt();
//    if(age<0){
//     throw new IllegalArgumentException(
//         "Age cannot be negative."
//     );
//    }
//    System.out.println("Age: "+age);

//-----------------------------throws------------------------------
// static void readFile() throws IOException{
// FileReader file= new FileReader("data.txt");
// System.out.println("File Opened.");
// }
// public static void main(String[] args) {
//     try{
//         readFile();
//     }catch(IOException e){
//         System.out.println("Could not find the file.");
//     }
// }

//------------------------Question------------------------------------------

int balance=5000;
int withdrawal=7000;
try{
    if(withdrawal > balance){
        throw new IllegalArgumentException(
            "Insufficient balance."
        );
    }
    balance -= withdrawal;
    System.out.println("Withdrawal was successfull.");
    System.out.println("Remaining balance: "+ balance);
}catch (IllegalArgumentException e){
    System.out.println(e.getMessage());
}
System.out.println("Program Completed.");
}
}
//}

/* 
NullPointerException
Trying to access a method or field through a null reference.
String name=null;
.Calling an instance method on a null object(e.g , str.length() when str is null).
*Accesing or modifying a field of a null object (e.g. , user.name).
*Taking the length of a null array or accessing its slots.

-ArrayIndexOutOfBoundsException
Accessing an array index that dosent exist.
int[]nums={1,2}; then nums[5]
*/
