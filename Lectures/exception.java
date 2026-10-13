package Lectures;

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

    try {
        // int res=10/0;
        // System.out.println(res);
        int[] numbers={10,20,30};
        System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid array index.");
        }catch(ArithmeticException e){
            System.out.println("Cannot be divided by 0.");
        }
    }
}

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
