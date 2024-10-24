package A14.Task1;

/*
Write a program that generates random names by combining first
and last names from hard-coded name arrays. The program should work
as follows:

Create two arrays, firstNames and lastNames, which contain first
and last names.

Ask the user how many random names the program should generate.

Generate random names using the following logic:

Choose the index value for the first name randomly.
Choose the index value for the last name randomly.
Use the index values to create a random full name
(i.e. first name and last name).
Print the generated full name.
Repeat these steps as many times as the user-specified
number of names to generate.
 */

import java.util.Scanner;

public class NameGenerator {
    public static void main(String[] args) {
        // First Name Array
        String[] firstNames = {"John", "Emily", "Michael", "Sophia", "Daniel", "Olivia", "James", "Ava", "David", "Isabella"};

        // Last Name Array
        String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Martinez", "Rodriguez"};

        double SIZE = 10;
        String randomFirstName, randomSecondName;
        int firstNameIdx, lastNameIdx;
        int count;
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many full name you would like to generate? ");
        count = Integer.parseInt(scanner.nextLine());
        System.out.println("Here is the list of name: ");

        for (int i = 0; i < count; i++){
            //index is from 0 to length -1, so if size is 10, can find from 0 - 9.99
            firstNameIdx = (int)(Math.random()* (SIZE));
            lastNameIdx = (int)(Math.random()* (SIZE));
            randomFirstName = firstNames[firstNameIdx];
            randomSecondName = lastNames[lastNameIdx];

            System.out.printf("%d. %s %s\n",(i+1),randomFirstName,randomSecondName);
        }
    }
}
