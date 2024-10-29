package Week1.A12.Task3;

import java.util.Scanner;

public class ObsoleteMeasures {
    public static void main(String[] args){
        final double LUOTI = 13.28;
        final double NAULA = 32 * LUOTI;
        final double LEVISKA = 20 * NAULA;

        int  leiviska, naula;
        double luoti, input, remain;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Weight (g): ");
        input = Double.parseDouble(scanner.nextLine());
        remain = input;
        leiviska = (int)(remain / LEVISKA);
        remain = remain -  (leiviska * LEVISKA);
        naula = (int)(remain/NAULA);
        remain = remain - (naula * NAULA);
        luoti = remain/LUOTI;

        System.out.printf("%d grams is %d leiviska, %d naula, %.2f luoti", (int)input,leiviska,naula,luoti);


    }
}
