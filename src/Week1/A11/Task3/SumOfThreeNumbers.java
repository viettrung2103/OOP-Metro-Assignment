package Week1.A11.Task3;

import java.util.Scanner;

public class SumOfThreeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give the first number:");
        int first = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the second number:");
        int second = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the third number:");
        //first way
//        int third = Integer.parseInt(scanner.nextLine());
        // second way
        double third = Double.parseDouble(scanner.nextLine());
        System.out.println("The sum of the numbers is " + (first + second + third)); // 13
        System.out.println("The product of the numbers is " + (first * second * third)); // 72

        /* the reason is the type of all the operands are integer so the result is integer.
        To have the expected result, there is two ways:
        1/ the sum need to be casted into type double.
        2/ cast any of the input into double type
         */
        // first way
//        System.out.println("The average of the numbers is " + (double)(first + second + third)/3); // should be 4.33,but result is 4
        // second way
        System.out.println("The average of the number is " + (first+ second + third)/3);
    }
}
