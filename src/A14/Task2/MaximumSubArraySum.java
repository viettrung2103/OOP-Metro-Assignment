package A14.Task2;

import java.util.Scanner;

public class MaximumSubArraySum {
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        int size, finalSize=0, finalStartIndex=0, currentMaxSum , finalMaxSum = 0;
        int[] numArray;
//        int[] finalMaxSumArray;
        int[] curSubArray;
        System.out.print("How many integers do you want to add: ");
        size = Integer.parseInt(scanner.nextLine());
        numArray = new int[size];

        for (int i = 0; i < size; i++){
            System.out.printf("Integer %d: ",i+1);
            numArray[i] = Integer.parseInt(scanner.nextLine());
        }
        for (int num: numArray){
            System.out.printf("%d ",num);
        }
        System.out.print("\n");
        for (int i = 1; i <= size; i++){ // size of sub-array
//            System.out.println("Array with size "+(i));
            curSubArray = new int[i];
            for(int j = 0; j <= size -i; j++){ // number of array with current size
//                System.out.println("sub array "+j );
                currentMaxSum = 0;
                for (int k = 0, t = j; k < i ;k++, t++){
                    //k : index of current subarray = 0, starting index of this round ( round 1, index = 1)
                    curSubArray[k] = numArray[t];
                    currentMaxSum += curSubArray[k];
                }
                // print out sub array
//                for (int num: curSubArray){
//                    System.out.print(num + " ");
//                }
                if (currentMaxSum > finalMaxSum) {
                    finalMaxSum = currentMaxSum;
                    finalSize = i;
                    finalStartIndex = j;
                }
//                System.out.print("\n");
            }

        }
        System.out.printf("\nMaximum sum: %d\n",finalMaxSum);
        System.out.printf("Integers: %d-%d",finalStartIndex+1,finalStartIndex + finalSize);

    }
}
