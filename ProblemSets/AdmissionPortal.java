package ProblemSets;


class StudentProfile {
    String name;
    int id;
    double score;

    // Constructor for students with an exam score
    StudentProfile(String name, int id, double score) {
        this.name = name;
        this.id = id;
        this.score = score;
    }

    // Constructor for walk-in students
    StudentProfile(String name, int id) {
        this.name = name;
        this.id = id;
        this.score = 0.0;
    }

    // Determine grade
    char calculateGrade() {
        if (score >= 90) {
            return 'A';
        } else if (score >= 75) {
            return 'B';
        } else if (score >= 50) {
            return 'C';
        } else {
            return 'F';
        }
    }

    // Print report card
    void displayReport() {
        System.out.println("Student Name: " + name);
        System.out.println("Student ID: " + id);
        System.out.println("Score: " + score);
        System.out.println("Grade: " + calculateGrade());
        System.out.println("--------------------");
    }
}

public class AdmissionPortal {
    public static void main(String[] args) {
        StudentProfile s1 = new StudentProfile("Tanvi", 101, 82.5);
        StudentProfile s2 = new StudentProfile("Rahul", 102);

        s1.displayReport();
        s2.displayReport();
    }
}

