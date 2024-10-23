package A13.Task3;

import java.util.Scanner;

public class PrimeNumberGenerator {
    public static void main(String[] args) {
        int first,second,count, primeCount= 0;
        String input;
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        while (running){
            System.out.print("Type the first number: ");
            first = Integer.parseInt(scanner.nextLine());
            System.out.print("Type the second number: ");
            second = Integer.parseInt(scanner.nextLine());
            if (first < 0 || second < 0) {
                System.out.println("Both numbers need to be positive interger");
                System.out.println("Type again");
            }
            if (first >= second) {
                System.out.println("second number must larger than first number");
                System.out.println("Type again");
            } else {
                System.out.printf("The prime numbers between %d and %d are:\n",first, second);
                for (int i = first; i <= second; i ++) {
                        count = 0;
                        if (i == 2) {
                            primeCount++;
                            System.out.printf("%d\t",i);
                        } else {
                            for (int j = first; j <= i; j ++){
                                if (i % j == 0){
                                    count ++;
                                }
                            }
                            if (count == 2){
                                if (primeCount == 8) {
                                    System.out.print("\n");
                                    primeCount = 0;
                                }
                                primeCount++;
                                System.out.printf("%d\t",i);
                            }
                        }
                }
                System.out.print("\nDo you want to play again?(yes/no) ");
                input = scanner.nextLine();
                if (input.equals("no")) {
                    running = false;
                }
            }
        }
        System.out.println("Thank you for using!!");




    }
}
