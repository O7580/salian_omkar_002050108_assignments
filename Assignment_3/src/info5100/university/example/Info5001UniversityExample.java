/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example;

import static com.sun.org.apache.xalan.internal.lib.ExsltMath.random;
import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.CourseSchedule.SeatAssignment;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.Faculty.FacultyAssignment;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author kal bugrara
 */
public class Info5001UniversityExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Department department = new Department("Information Systems");
        CourseCatalog coursecatalog = department.getCourseCatalog();
        StudentDirectory studentDirectory = department.getStudentDirectory();
        
//        Course course = coursecatalog.newCourse("app eng", "info 5100", 4);
//        
//        CourseSchedule courseschedule = department.newCourseSchedule("Fall2020");
//
//        CourseOffer courseoffer = courseschedule.newCourseOffer("info 5100");
//        if (courseoffer==null)return;
//        courseoffer.generatSeats(10);
//        PersonDirectory pd = department.getPersonDirectory();
//        Person person = pd.newPerson("0112303");
//        StudentDirectory sd = department.getStudentDirectory();
//        StudentProfile student = sd.newStudentProfile(person);
//        CourseLoad courseload = student.newCourseLoad("Fall2020"); 
////        
//        courseload.newSeatAssignment(courseoffer); //register student in class
//        
//        int total = department.calculateRevenuesBySemester("Fall2020");
//        System.out.print("Total: " + total);
    
          // Predefined courses
        Course[] predefinedCourses = {
            new Course("app eng", "info 5100", 4),
            new Course("web eng", "info 5200", 4),
            new Course("database", "info 5300", 4),
            new Course("system design", "info 5400", 4),
            new Course("networking", "info 5500", 4)
        };
        for (Course course : predefinedCourses) {
            coursecatalog.newCourse(course.getName(), course.getCOurseNumber(), course.getCredits());
        }
        
 
        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        String semester = scanner.nextLine();
        CourseSchedule courseSchedule = department.newCourseSchedule(semester);
        courseSchedule.generateCourseOffers(coursecatalog);
        
         ArrayList<StudentProfile> students = createStudentProfiles();

        // Generate report for Fall2024 semester
        String semester1 = "Fall2024"; // Example semester
       // generateSemesterReport(students, semester1);
    

 
            boolean exitMenu = false;
            while (!exitMenu) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Manage Course Catalog");
            System.out.println("2. Manage Course Schedule");
            System.out.println("3. Manage Student Course Registrations");
            System.out.println("4. Generate Semester Report");
            //System.out.println("5. Generate Department Report");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                manageCourseCatalog(coursecatalog, scanner);
                break;
            case 2:
                manageCourseSchedule(coursecatalog, courseSchedule, scanner);
                break;
            case 3:
                manageStudentCourseRegistrations(studentDirectory, courseSchedule, scanner);
                break;
            case 4:
                generateSemesterReport(students, semester1);
                break;
//            case 5:
//                  populateDepartmentData(department, coursecatalog, courseSchedule);
//                break;
            case 5:
                exitMenu = true;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
        

        // Close the scanner
        scanner.close();
    }

}
