package inheritance;

class Device{
void poweron(){
    System.out.println("DDevice powered on.");
}
}

class DabbaPhone extends Device{
void makecall(){
    System.out.println("Making a call.....");
}
}

class Smartphone extends DabbaPhone{
   void browse_internet(){
    System.out.println("Opening Browser.");
   }
}

public class multilevel {
    public static void main(String[] args) {
        Smartphone samsung=new Smartphone();
    samsung.browse_internet();
    samsung.makecall();
    } 
}
