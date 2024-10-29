package Week1.A13.Task1;

/*
Write a program that prompts the user to enter the coefficients
of a quadratic equation (ax^2 + bx + c = 0) and calculates its
roots using the quadratic formula. Display the roots on the console.
If the equation has no real roots, display the message "No real roots".
 */


import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double a,b,c, delta;
        System.out.print("a = ");
        a = Double.parseDouble(scanner.nextLine());
        System.out.print("b = ");
        b = Double.parseDouble(scanner.nextLine());
        System.out.print("c = ");
        c = Double.parseDouble(scanner.nextLine());
        delta = Math.pow(b,2) - 4 * a * c;
        if (delta < 0) {
            System.out.println("There is no roots.");
        } else if (delta == 0) {
            double root ;
            root =  - b / (2 * a);
            System.out.println("There is one root:");
            System.out.printf("x = %6.2f",root);
        } else {
            double root1,root2;
            root1 = (-b + Math.sqrt(delta))/(2*a);
            root2 = (-b - Math.sqrt(delta))/(2*a);
            System.out.println("There are two roots:");
            System.out.printf("x1 = %6.2f\nx2 = %6.2f",root1,root2);
        }
    }
}
