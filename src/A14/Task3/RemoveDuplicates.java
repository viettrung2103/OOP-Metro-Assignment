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

        System.out.println("Enter the integers into the array: ");
        for (int i = 0; i < size; i++){
            System.out.printf("Enter integer %d: ", i+1);
            value = Integer.parseInt(scanner.nextLine());
            numArr[i] = value;
        }
        Arrays.sort(numArr);
        for (int num:numArr){
            System.out.print(num+" ");
        }
        for (int i = 0, j = 0; i < size; i++){
            if (i == 0) {
                finalNumArray[j] = numArr[i];
                j++;
            }
            else {
                if (numArr[i] != numArr[i-1]){
                    finalNumArray[j] = numArr[i];
                    j++;
                }
            }
        }
        System.out.print("\n");
        System.out.print("\n");
        System.out.println("The array without duplicates:");
        for (int i = 0; i < size;i++){
            if (i == 0 || finalNumArray[i] != 0){
                System.out.print(finalNumArray[i] +" ");
            }
        }
//        System.out.printf("Array: " + numArr);
    }
}
