package A14.Task3;

import java.util.Scanner;
import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int size, value ;
        int[] numArr, finalNumArray;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        size = Integer.parseInt(scanner.nextLine());
        numArr =  new int[size];
        finalNumArray = new int[size];

        // add check if user input 0 or not
        boolean hasZero = false;

        System.out.println("Enter the integers into the array: ");
        for (int i = 0; i < size; i++){
            System.out.printf("Enter integer %d: ", i+1);
            value = Integer.parseInt(scanner.nextLine());
            numArr[i] = value;
        }

        for (int i = 0; i < size; i++){
            if (numArr[i] == 0){
                hasZero = true;
            }
        }

        Arrays.sort(numArr);

        for (int num:numArr){
            System.out.print(num+" ");
        }

        for (int i = 0, j = 0; i < size; i++, j++){
            if (i == 0) {
                finalNumArray[j] = numArr[i];

            }
            else {
                if (numArr[i] != numArr[i-1]){
                    finalNumArray[j] = numArr[i];

                }
            }
        }
        System.out.println();
        int countZero = 0;

        System.out.println("The array without duplicates:");
        for (int i = 0 ; i< size; i++ ) {
            // check case if array has one or more than one 0
            if (hasZero) {
                if (finalNumArray[i] == 0) {
                    if (countZero == 0) {
                        System.out.print(finalNumArray[i] + " ");
                        countZero++;
                    }
                } else {
                    System.out.print(finalNumArray[i] + " ");
                }
            } else {
                if (finalNumArray[i] != 0) {
                    System.out.print(finalNumArray[i] + " ");
                }
            }
        }
    }
}
