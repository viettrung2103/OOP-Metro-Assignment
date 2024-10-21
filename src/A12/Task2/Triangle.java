package A12.Task2;

import java.util.Scanner;

public class Triangle {

    public static void main(String[] args){
        double side1;
        double side2;
        double hypotenuse;
        double result;

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the length of side 1");
        side1 = Double.parseDouble(scanner.nextLine());
        System.out.println("What is the length of side 2");
        side2 = Double.parseDouble(scanner.nextLine());

        result = Math.pow(side1,2) + Math.pow(side2,2);
        hypotenuse = Math.sqrt(result);

        System.out.printf("With side1: %.1f, side2: %.1f, the hypotenuse: %.1f", side1,side2, hypotenuse);

    }
}
