package Week3.A34.Task3;

import java.io.*;

public class Main {
    public final static String FILENAME = "enrollments.ser";

    public static void main(String[] args) {
        Student student1 = new Student(1, "student1", 29);
        Student student2 = new Student(2, "student2", 29);
        Course course1 = new Course("11", "course1", "prof1");


        File f = new File(FILENAME);
        Enrollment enrollment = new Enrollment(student1, course1, "12.11.2024'");
        ;

        // if there is file, read from file deserialize
        if (f.exists() & f.isFile()) {
            enrollment = deSerializeEnrollment(FILENAME);
            System.out.println(enrollment);

        } else {

            // if there is no file, serialize and write to file
            serializeEnrollment(enrollment, FILENAME);
        }

    }

    private static void serializeEnrollment(Enrollment enrollment, String filename) {
        try (
                FileOutputStream outputStream = new FileOutputStream(filename);
                ObjectOutputStream objects = new ObjectOutputStream(outputStream);
        ) {
            objects.writeObject(enrollment);
        } catch (Exception e) {
            System.err.println("Fail to writing enrollment: " + e);
        }
    }

    private static Enrollment deSerializeEnrollment(String filename) {
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (Enrollment) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Failed to read enrollment: " + e.getMessage());
            return null;
        }
    }
}
