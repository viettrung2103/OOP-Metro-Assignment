package A12.Task1;

import java.util.Scanner;

public class Convert {
    public static void main(String[] args){
        double CONST1 = 32;
        double CONST2 = 5.0/9;
        double result;

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is temperature:");
        double input = Double.parseDouble(scanner.nextLine());
        result = (input - CONST1) * CONST2;
        System.out.printf("The result: %.1f F - %.1f C",input, result);
    }
}
