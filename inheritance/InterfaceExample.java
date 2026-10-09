
package inheritance;

interface mother {
    void message();
}

interface father {
    void message();
}

class Son implements mother, father {
    public void message() {
        System.out.println("Love Mom and Dad");
    }
}

public class InterfaceExample {
    public static void main(String[] args) {

        Son s = new Son();
        s.message();

        mother m = new Son();
        m.message();

        father f = new Son();
        f.message();
    }
}
