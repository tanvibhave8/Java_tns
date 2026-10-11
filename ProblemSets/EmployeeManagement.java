package ProblemSets;


class Employee {
    private int id;
    private String name;
    private double salary;

    // Constructor
    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;

        if (salary >= 0) {
            this.salary = salary;
        } else {
            this.salary = 0.0;
        }
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // Setter
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Error: Salary cannot be negative!");
        }
    }

    // Give raise
    public void giveRaise(double percent) {
        salary = salary + (salary * percent / 100);
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        Employee e = new Employee(101, "Alice", 50000.0);

        e.giveRaise(8);

        System.out.println("Updated Salary: " + e.getSalary());

        // Try setting negative salary
        e.setSalary(-10000);
        
        System.out.println("Final Salary: " + e.getSalary());
    }
}

