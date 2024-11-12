package Week3.A34.Task3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {
    private int id;
    private String name;
    private int age;
    private List<Course> courseList;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.courseList = new ArrayList<>();

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void enroll(Course course) {
        System.out.println("Enrolling the course " + course);
        if (!this.courseList.contains(course)) {
            this.courseList.add(course);
            System.out.println("Success Enrollment");

        } else System.out.println("Fail Enrollment");
    }

    public Course unenroll(Course course) {

        for (Course curCourse : courseList) {
            if (curCourse.equals(course)) {
                this.courseList.remove(course);
                return curCourse;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object studentObj) {
        // is object null
        if (studentObj == null) {
            return false;
        }
        // is the comparing object has the same class
        if (this.getClass() != studentObj.getClass()) {
            return false;
        }
        Student compared = (Student) studentObj;

        return this.id == compared.getId();
    }

    @Override
    public String toString() {
        return this.id + ". " + this.name + " - " + this.age;
    }


}
