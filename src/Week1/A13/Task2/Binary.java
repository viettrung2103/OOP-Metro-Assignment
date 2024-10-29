package Week1.A13.Task2;

import java.util.Scanner;

/*
Write a program that prompts the user to enter
a binary number (composed of 0s and 1s)
and converts it to decimal. Display
the decimal equivalent on the console.
Hint: use the charAt method of the String class
to retrieve the individual bits in the input string.
 */
public class Binary {
    public static void main(String[] args) {
    String biInput ;
    char inputChar;
    int biInputLenghth, convertedValue;
    double result = 0;
    Scanner scanner = new Scanner(System.in);
    boolean validBiInput ;

    do{
        //validate input number as binary numer
        validBiInput = true;
        System.out.print("Type the binary number: ");
        biInput = scanner.nextLine();
        biInputLenghth = biInput.length();

        for (int i = 0; i <= biInputLenghth-1; i++){
            inputChar = biInput.charAt(i);
//            System.out.println("char "+ inputChar);
            if (inputChar != '0' && inputChar != '1') {
                validBiInput = false;
                break;
            }
        }
        if (!validBiInput){
            System.out.printf("%s is not a binary number\n", biInput);
            System.out.println("Binary number contains only 1 and 0");
        }

    } while ( !validBiInput);
        System.out.printf("%s is binary number\n",biInput);
        for (int j = 0; j <= biInputLenghth-1; j++) {
            inputChar = biInput.charAt(j);
            // in ASCII, '0' is 48, so input char - '0' will return the remain, from 0 -9
            convertedValue = inputChar  - '0';
            result += convertedValue * Math.pow(2,biInputLenghth-1-j);
        }
        System.out.printf("The converted value of %s is %.0f", biInput,result);

    }
}
