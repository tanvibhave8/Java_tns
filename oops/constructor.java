package oops;

class Car{
    String color;
    String brand;
    int speed;


    Car(String color,String brand,int speed){
        this.color=color;
        this.brand=brand;
        this.speed=speed;
    }

    void displayInfo(){
    System.out.println("Color :" + color + "Brand :" + "Speed :" +speed + ".");
}

void acceleration(int incr){
    int or_speed=speed;
    speed+=incr;
    System.out.println("Original speed :" + or_speed);
    System.out.println(brand + " accelrated by " + speed + " km/hr.");
}
}


public class constructor {
    public static void main(String[]args){
    Car c1=new Car(" Blue " , " BMW ", 300);
    c1.displayInfo();
    c1.acceleration(50);
}
}