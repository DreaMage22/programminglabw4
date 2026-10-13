
package week4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();

       
        int numCourses = 0;
        while (numCourses < 3) {
            System.out.print("How many courses to create? (At least 3): ");
            numCourses = Integer.parseInt(scanner.nextLine().trim());
            if (numCourses < 3) {
                System.out.println("You must create at least 3 courses!");
            }
        }

        for (int i = 0; i < numCourses; i++) {
            System.out.println("\n--- Creating Course " + (i + 1) + " ---");
            System.out.print("Enter course name: ");
            String cName = scanner.nextLine().trim();

            System.out.print("Enter classroom capacity: ");
            int cCapacity = Integer.parseInt(scanner.nextLine().trim());

            courses.add(new Course(cName, cCapacity));
        }

       
        System.out.println("\n=== AVAILABLE COURSES ===");
        for (Course c : courses) {
            System.out.println("- " + c.getCourseName() + " (Capacity: " + c.getCapacity() + ")");
        }

        
        while (true) {
            System.out.println("\n=== REGISTRATION MENU ===");
            System.out.println("1. Register a student to a course");
            System.out.println("2. View all courses");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            if(choice.equals("1")) {
                System.out.print("Enter Student ID: ");
                String sID = scanner.nextLine().trim();

                System.out.print("Enter Student Name: ");
                String sName = scanner.nextLine().trim();

                System.out.print("Enter Course Name to register: ");
                String targetCourseName = scanner.nextLine().trim();

               
                Course targetCourse = null;
                for (Course c : courses) {
                    if (c.getCourseName().equalsIgnoreCase(targetCourseName)) {
                        targetCourse = c;
                        break;
                    }
                }

                if (targetCourse == null) {
                    System.out.println("No course found with that name.");
                    continue;
                }

                
                if (targetCourse.getEnrolledStudents().size() >= targetCourse.getCapacity()) {
                    System.out.println("This course is full. Registration failed.");
                    continue;
                }

                
                boolean alreadyRegistered = false;
                for (Student s : targetCourse.getEnrolledStudents()) {
                    if (s.getStudentID().equalsIgnoreCase(sID)) {
                        alreadyRegistered = true;
                        break;
                    }
                }

                if (alreadyRegistered) {
                    System.out.println("This student is already registered for this course.");
                    continue;
                }

                
                Student newStudent = new Student(sID, sName);
                targetCourse.getEnrolledStudents().add(newStudent);
                System.out.println("Registration successful.");

            } else if (choice.equals("2")) {
                
                System.out.println("\n=== ALL COURSES OVERVIEW ===");
                for (Course c : courses) {
                    c.displayCourseInfo();
                }
            } else if (choice.equals("3")) {
                System.out.println("Exiting program.");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
}
