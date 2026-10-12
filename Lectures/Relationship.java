package Lectures;

//HAS-A Relationship

// class Engine{
//     void start(){
//         System.out.println("Engine is starting....");
//     }
// }

// class Car{
//     private Engine engine;
//     Car(){
//         this.engine=new Engine();
//     }
//     void drive(){
//         engine.start();
//         System.out.println("Car is moving....");
//     }
// }



// class Adress{
//     String city;
//     String state;
//     int pincode;

//     Adress(String city, String state, int pincode){
//         this.city=city;
//         this.state=state;
//         this.pincode=pincode;
//     }
//     void displayAdress(){
//         System.out.println(city + ", "+ state + ", "+ pincode);
//     }
// }
// class Student{
//     String name;
//     int rollNumber;
//     Adress address;

//     Student(String name, int rollNumber, Adress address){
//         this.name=name;
//         this.rollNumber=rollNumber;
//         this.address=address;
//     }

//     void displayProfile(){
//         System.out.println("Student: "+ name );
//         System.out.println("Roll No. "+ rollNumber);
//         System.out.println("Lives at: ");
//         address.displayAdress();
//     }
// }





class Battery{
    int capacityMaH;
    Battery(int capacityMaH){
        this.capacityMaH=capacityMaH;
    }

    void drain(){
        System.out.println("Battery Used. \n Capacity remaining: " + (capacityMaH-100) + capacityMaH);
    }
}

class Camera{
    int pix;

    Camera(int pix){
        this.pix=pix;
    }
    void takePhoto(){
        System.out.println("Click....Captured a photo with " + pix + " sensor.");
    }
}

class Phone{
    String brand;
    Battery battery;
    Camera camera;

    Phone(String brand, Battery battery, Camera camera){
        this.brand=brand;
        this.battery=battery;
        this.camera=camera;
    }
    void snapPicture(){
        System.out.println("[ " + brand + " ]" + "is active." );
        camera.takePhoto();
        battery.drain();
    }
}