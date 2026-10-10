package Basics;

import java.util.Scanner;

public class Area_Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.println("3. Square");
        System.out.print("Choose shape: ");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter radius: ");
                double r = sc.nextDouble();
                System.out.println("Area = " + (Math.PI * r * r));
                break;

            case 2:
                System.out.print("Enter length and breadth: ");
                double l = sc.nextDouble();
                double b = sc.nextDouble();
                System.out.println("Area = " + (l * b));
                break;

            case 3:
                System.out.print("Enter side: ");
                double s = sc.nextDouble();
                System.out.println("Area = " + (s * s));
                break;

            default:
                System.out.println("Invalid choice");
        }

        sc.close();
    }
}