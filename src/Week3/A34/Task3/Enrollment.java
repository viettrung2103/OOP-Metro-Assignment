package Week3.A34.Task3;

import java.io.Serializable;

public class Enrollment implements Serializable {
    private Student student;
    private Course course;
    private String enrollmentDate;

    public Enrollment(Student student, Course course, String enrollmentDate) {
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        student.enroll(course);
        course.addStudent(student);
//        System.out.println(this);
    }

    public Student getStudent() {
        return this.student;
    }

    public Course getCourse() {
        return this.course;
    }

    public String getEnrollmentDate() {
        return this.enrollmentDate;
    }

    @Override
    public String toString() {
        return "Enrollment:\nStudent: " + this.student.getName() + ". Course: " + this.course.getCourseName() + ". Date: " + this.enrollmentDate;
    }
}
