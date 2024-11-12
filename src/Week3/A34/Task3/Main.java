package Week3.A34.Task3;

import java.io.*;

public class Main {
    public final static String FILENAME = "enrollments.ser";

    public static void main(String[] args) {
        Student student1 = new Student(1, "student1", 29);
        Student student2 = new Student(2, "student2", 29);
        Course course1 = new Course("11", "course1", "prof1");


        File f = new File(FILENAME);
        Enrollmment enrollmment = new Enrollmment(student1, course1, "12.11.2024'");;

        // if there is file, read from file deserialize
        if (f.exists() & f.isFile()) {
            try (
                    FileInputStream inputStream = new FileInputStream(FILENAME);
                    ObjectInputStream objects = new ObjectInputStream(inputStream);
            ) {
                enrollmment = (Enrollmment) objects.readObject();
            } catch (Exception e) {
                System.err.println("Fail to read enrollment: " + e);
            }
        } else {

            // if there is no file, serialize and write to file
            try (
                    FileOutputStream outputStream = new FileOutputStream(FILENAME);
                    ObjectOutputStream objects = new ObjectOutputStream(outputStream);
            ) {
                objects.writeObject(enrollmment);
            } catch (Exception e) {
                System.err.println("Fail to writing enrollment: " + e);
            }
        }
//        System.out.println("Enrollment: " + enrollmment);
    }
}
