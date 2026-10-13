
package week4;

import java.util.ArrayList;
import java.util.List;


public class Course {
    private String courseName;
    private int capacity;
    private List<Student> enrolledStudents;

    
    public Course(String courseName, int capacity) {
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

   
    public String getCourseName() {
        return courseName;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    
    public void displayCourseInfo() {
        System.out.println("Course: " + courseName + " | Capacity: " + capacity + " | Enrolled: " + enrolledStudents.size());
        if (enrolledStudents.isEmpty()) {
            System.out.println("  (No students enrolled yet)");
        } else {
            System.out.print("  Enrolled Students: ");
            for (int i = 0; i < enrolledStudents.size(); i++) {
                System.out.print(enrolledStudents.get(i).getName() + " (" + enrolledStudents.get(i).getStudentID() + ")");
                if (i < enrolledStudents.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
