package Week3.A34.Task3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable {
    private String courseCode;
    private String courseName;
    private String instructor;
    private List<Student> studentList;

    public Course(String courseCode, String courseName, String instructor) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructor = instructor;
        this.studentList = new ArrayList<>();
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getCourseCode() {
        return this.courseCode;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public String getInstructor() {
        return this.instructor;
    }

    public void addStudent(Student student) {
        if (student != null) {
            this.studentList.add(student);
        }
    }

    public Student removeStudent(Student student) {
        for (Student curStudent : this.studentList) {
            if (curStudent.equals(student)) {
                this.studentList.remove(student);
                return curStudent;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object courseObj) {
        // is object null
        if (courseObj == null) {
            return false;
        }
        // is the comparing object has the same class
        if (this.getClass() != courseObj.getClass()) {
            return false;
        }
        Course compared = (Course) courseObj;

        return this.courseCode.equals(compared.courseCode);
    }

    @Override
    public String toString() {
        return this.courseCode + " ." + this.getCourseName() + " by " + this.instructor;
    }
}
