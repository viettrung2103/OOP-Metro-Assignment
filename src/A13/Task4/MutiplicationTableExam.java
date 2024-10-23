package A13.Task4;

import java.util.Scanner;

/*
In primary school, students must memorize the multiplication tables
for numbers 1 to 10. Create a program to assist primary school students
that presents the user with ten randomly generated multiplication problems,
where the factors are integers between one and ten.
After each answer, the program indicates whether it was correct or not.
The user receives one point for each correctly answered question.
If the user scores ten points for the entire set of problems,
the program congratulates them on mastering the multiplication tables
and terminates. Otherwise, the program starts a new set of problems.
 */

public class MutiplicationTableExam {
    public static void main(String[] args){
        double MIN = 1, MAX = 10;

        int  input,result, point, first, second;
        Scanner scanner = new Scanner(System.in);


        point = 0;
        System.out.println("Welcome to the Multiplication Table Exam!");
        while (point < (int)MAX) {
            for (int i = 1; i <= MAX ; i++){

            System.out.printf("Question %d:\n",(i));

            first = (int)(MIN + Math.random() * (MAX - MIN + 1));
            second = (int)(MIN + Math.random() * (MAX - MIN + 1) );
            result = (first * second);
            System.out.printf("%d * %d = ",first, second);
            input = Integer.parseInt(scanner.nextLine());
            if (result != input){
                System.out.println("Incorrect!!");
            } else {
                System.out.println("Correct!!");
                point ++;
            }
            System.out.printf("Result: %d / %.0f\n", point,MAX);
            System.out.println("---");
            }
            if (point == (int)MAX){
                System.out.println("Congratulation!");
                System.out.println("You have completed the exam successfully");
            } else {
                System.out.println("Disappointing!!");
                System.out.println("You have failed the exam. You have to retake the exam.");
                point = 0;
            }
        }
    }
}
