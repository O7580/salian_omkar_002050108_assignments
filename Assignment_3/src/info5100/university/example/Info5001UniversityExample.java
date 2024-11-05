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
    
    private static void browseCourseCatalog(CourseCatalog courseCatalog) {
        System.out.println("Course Catalog:");
        for (Course course : courseCatalog.getCourseList()) {
            System.out.println("Name: " + course.getName() + ", Number: " + course.getCOurseNumber() + ", Credits: " + course.getCredits());
        }
    }
    
    private static void addNewCourse(CourseCatalog courseCatalog, Scanner scanner) {
        System.out.print("Enter course name: ");
        String name = scanner.nextLine();

        System.out.print("Enter course number: ");
        String number = scanner.nextLine();

        System.out.print("Enter course credits: ");
        int credits = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Course course = courseCatalog.newCourse(name, number, credits);
        System.out.println("Course added successfully: " + course.getName());
    }
    
    private static void addNewCourseOffer(CourseCatalog courseCatalog, CourseSchedule courseSchedule, Scanner scanner) {
        // Display available courses for selection
        System.out.println("Available Courses:");
        for (Course course : courseCatalog.getCourseList()) {
            System.out.println(course.getCOurseNumber() + ": " + course.getName());
        }

        // Prompt user to select a course
        System.out.print("Enter the course number for the new course offer: ");
        String courseNumber = scanner.nextLine();

        // Retrieve the course from the course catalog
        Course course = courseCatalog.getCourseByNumber(courseNumber);
        if (course == null) {
            System.out.println("Course not found in catalog.");
            return;
        }

        // Prompt user to enter the faculty name
        System.out.print("Enter the faculty name for this course offer: ");
        String facultyId = scanner.nextLine();

        // Create and add the course offer to the course schedule
        CourseOffer courseOffer = courseSchedule.newCourseOffer(courseNumber);
        PersonDirectory personDirectory = new PersonDirectory(); // Assuming you have a PersonDirectory class

        // Assuming you have a method in your PersonDirectory class to retrieve a Person object by name
        Person person = personDirectory.newPerson(facultyId);
        
        if (person == null) {
        System.out.println("Faculty not found.");
        return;
    }

        FacultyProfile facultyProfile = new FacultyProfile(person);
        courseOffer.AssignAsTeacher(facultyProfile);
        System.out.println("Course offer added successfully.");
    }
    
    private static void displayCourseSchedule(CourseSchedule courseSchedule) {
        
        
        System.out.println("\nCourse Schedule:");
        System.out.println("Semester:  "+courseSchedule.getSemester());
        System.out.println("Course Offers:");
        
       ArrayList<CourseOffer> courseOffers = courseSchedule.getCourseOffers();

    for (CourseOffer courseOffer : courseOffers) {
        Course course = courseOffer.getCourse();
        String courseName = course.getName();
        String courseNumber = course.getCOurseNumber();
        
        // Check if faculty assignment exists
        FacultyAssignment facultyAssignment = courseOffer.getFacultyassignment();
        if (facultyAssignment != null) {
            FacultyProfile facultyProfile = facultyAssignment.getFacultyProfile();
            if (facultyProfile != null) {
                Person facultyPerson = facultyProfile.getPerson();
                String facultyName = facultyPerson.getPersonId(); // Assuming personId is the faculty name
                System.out.println("Course: " + courseName + " | Number: " + courseNumber + " | Faculty: " + facultyName);
            } else {
                System.out.println("Course: " + courseName + " | Number: " + courseNumber + " | No faculty assigned");
            }
        } else {
            System.out.println("Course: " + courseName + " | Number: " + courseNumber + " | No faculty assignment");
        }
    }
    }
    
    private static void processCourseRegistration(StudentProfile studentProfile, CourseSchedule courseSchedule, Scanner scanner) {
    // Prompt user to select a semester
    System.out.print("Enter semester: ");
    String semester = scanner.nextLine();

    // Retrieve or create the course load for the specified semester
    CourseLoad courseLoad = studentProfile.getCourseLoadBySemester(semester);
    if (courseLoad == null) {
        courseLoad = studentProfile.newCourseLoad(semester);
    }

    // Display available courses from the course catalog for registration
    CourseCatalog courseCatalog = courseSchedule.getCoursecatalog();
    System.out.println("Available Courses for Registration:");
    for (Course course : courseCatalog.getCourseList()) {
        System.out.println("Number: " + course.getCOurseNumber() + ", Name: " + course.getName());
    }

    // Prompt user to select a course for registration
    System.out.print("Enter the course number to register for: ");
    String courseNumber = scanner.nextLine();

    // Check if the entered course number matches any of the predefined courses
    Course selectedCourse = null;
    for (Course course : courseCatalog.getCourseList()) {
        if (course.getCOurseNumber().equals(courseNumber)) {
            selectedCourse = course;
            break;
        }
    }

    // If the selected course is not found in the predefined list, show an error
    if (selectedCourse == null) {
        System.out.println("Course not found.");
        return;
    }

    // Retrieve the course offer from the course schedule
    CourseOffer courseOffer = courseSchedule.getCourseOfferByNumber(courseNumber);
    if (courseOffer == null) {
        System.out.println("Course offer not found.");
        return;
    }

    // Register student for the selected course
    SeatAssignment seatAssignment = courseOffer.assignEmptySeat(courseLoad);
    if (seatAssignment == null) {
        System.out.println("No available seats for this course.");
    } else {
        // If registration is successful, display confirmation message
        System.out.println("Student successfully registered for course.");

        // Retrieve the student ID from the student profile
        String studentId = studentProfile.getStudentId(); // Assuming getStudentId() returns the student's ID

        // Set the student ID in the seat assignment
        seatAssignment.setStudentId(studentId);
    }
}
    
        private static void manageCourseCatalog(CourseCatalog courseCatalog, Scanner scanner) {
         boolean exitCatalogMenu = false;
         while (!exitCatalogMenu) {
             System.out.println("\nCourse Catalog Management:");
             System.out.println("1. Browse Course Catalog");
             System.out.println("2. Add a New Course");
             System.out.println("3. Exit Course Catalog Management");
             System.out.print("Enter your choice: ");

             int choice = scanner.nextInt();
             scanner.nextLine(); // Consume newline

             switch (choice) {
                 case 1:
                     browseCourseCatalog(courseCatalog);
                     break;
                 case 2:
                     addNewCourse(courseCatalog, scanner);
                     break;
                 case 3:
                     exitCatalogMenu = true;
                     break;
                 default:
                     System.out.println("Invalid choice. Please try again.");
             }
         }
        
     }
        
        private static void manageCourseSchedule(CourseCatalog courseCatalog, CourseSchedule courseSchedule, Scanner scanner) {
         boolean exitScheduleMenu = false;
         while (!exitScheduleMenu) {
             System.out.println("\nCourse Schedule Management:");
             System.out.println("1. Add a New Course Offer");
             System.out.println("2. Display Course Schedule");
             System.out.println("3. Exit Course Schedule Management");
             System.out.print("Enter your choice: ");

             int choice = scanner.nextInt();
             scanner.nextLine(); // Consume newline

             switch (choice) {
                 case 1:
                     System.out.print("Enter the semester for the new course schedule: ");
                     String semester = scanner.nextLine();
                     courseSchedule = courseCatalog.getDepartment().newCourseSchedule(semester); // Update courseSchedule with new semester
                     addNewCourseOffer(courseCatalog, courseSchedule, scanner);
                     break;
                 case 2:
                     displayCourseSchedule(courseSchedule);
                     break;
                 case 3:
                     exitScheduleMenu = true;
                     break;
                 default:
                     System.out.println("Invalid choice. Please try again.");
             }
         }
            
            
     }
        
        private static ArrayList<StudentProfile> createStudentProfiles() {
        ArrayList<StudentProfile> students = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            String studentId = String.format("%03d", i); // Generate a random student ID
            Person person = new Person("Name" + i); // Example person details (assuming name is the only parameter)
            StudentProfile studentProfile = new StudentProfile(person); // Create a new student profile
            studentProfile.setStudentId(studentId); // Set the student ID separately
            students.add(studentProfile);
        }
        return students;
    }
        
        private static void manageStudentCourseRegistrations(StudentDirectory studentDirectory, CourseSchedule courseSchedule, Scanner scanner) {
           while (true) {
            System.out.println("\nChoose Student Registration Option:");
            System.out.println("1. New Student Registration");
            System.out.println("2. Existing Student Registration");
           // System.out.println("3. View Registrations by Course");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int registrationOption = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (registrationOption) {
                case 1:
                    // New student registration
                    registerNewStudent(studentDirectory, courseSchedule, scanner);
                    break;
                case 2:
                    // Existing student registration
                    registerExistingStudent(studentDirectory, courseSchedule, scanner);
                    break;
//                case 3:
//                // View registrations by course
//                viewRegistrationsByCourse(courseSchedule);
//                break;
                
                case 3:
                    // Exit
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
        
        private static void registerNewStudent(StudentDirectory studentDirectory, CourseSchedule courseSchedule, Scanner scanner) {
        // Prompt user for new student ID
        System.out.print("Enter new student ID: ");
        String studentId = scanner.nextLine();

        // Create new student profile
        Person studentPerson = new Person(studentId);
        StudentProfile studentProfile = studentDirectory.newStudentProfile(studentPerson);

        // Proceed with course registration
        processCourseRegistration(studentProfile, courseSchedule, scanner);
    }
        
        private static void registerExistingStudent(StudentDirectory studentDirectory, CourseSchedule courseSchedule, Scanner scanner) {
    // Predefined students
    String[][] predefinedStudents = {
        {"001", "Alice"},
        {"002", "Bob"},
        {"003", "Charlie"},
        {"004", "David"},
        {"005", "Eve"}
    };

    // Display predefined students
    System.out.println("Predefined Students:");
    for (String[] student : predefinedStudents) {
        System.out.println("ID: " + student[0] + ", Name: " + student[1]);
    }

    // Prompt user to select an existing student by ID
    System.out.print("Enter existing student ID to register: ");
    String studentId = scanner.nextLine();

    // Check if the entered student ID is valid
    boolean isValidStudent = false;
    for (String[] student : predefinedStudents) {
        if (student[0].equals(studentId)) {
            isValidStudent = true;
            break;
        }
    }

    if (!isValidStudent) {
        System.out.println("Invalid student ID.");
        return;
    }

    // Retrieve the existing student profile from the student directory
    StudentProfile studentProfile = studentDirectory.findStudent(studentId);
    if (studentProfile == null) {
        // Create a new student profile if not found
        Person studentPerson = new Person(studentId);
        studentProfile = studentDirectory.newStudentProfile(studentPerson);
    }

    // Proceed with course registration
    processCourseRegistration(studentProfile, courseSchedule, scanner);
}

        
        private static void generateSemesterReport(ArrayList<StudentProfile> students, String semester) {
            System.out.println("Semester Report for " + semester + ":\n");
            Random random = new Random();
            String[] courses = {"Info 5100", "Info 5200", "ENCP 2000", "Info 5400", "Info 5500", "DAMG 6000"};
            String[] professors = {"Prof. Smith", "Prof. Johnson", "Prof. Williams", "Prof. Brown", "Prof. Jones", "Prof. Davis"};

            for (StudentProfile student : students) {
                System.out.println("Student: " + student.getStudentId()); // Get student ID

                // Print specified courses and their professors
                System.out.println("Courses:");
                HashSet<Integer> selectedIndices = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    int index;
                    do {
                        index = random.nextInt(courses.length);
                    } while (selectedIndices.contains(index));
                    selectedIndices.add(index);
                    System.out.println(courses[index] + " : " + professors[index]);
                }

                // Generate and print random grades
                System.out.print("Grades: [");
                double sumGPA = 0.0;
                for (int i = 0; i < 3; i++) {
                    char grade = (char) (random.nextInt(4) + 'A');
                    System.out.print(grade);
                    sumGPA += convertGradeToGPA(grade);
                    if (i < 2) {
                        System.out.print(", ");
                    }
                }
                System.out.println("]");

                // Calculate and print average GPA
                double averageGPA = sumGPA / 3.0; // Calculate average GPA
                System.out.println("Average GPA: " + String.format("%.2f", averageGPA));

                // Generate and print random tuition fee
                int tuitionFee = 4000 + random.nextInt(2000);
                System.out.println("Tuition Fee: $" + tuitionFee);

                System.out.println(); // Add a newline for readability
            }
        }
        
        private static double convertGradeToGPA(char grade) {
        switch (grade) {
            case 'A':
                return 4.0;
            case 'B':
                return 3.0;
            case 'C':
                return 2.0;
            case 'D':
                return 1.0;
            default:
                return 0.0; // Return 0.0 for unrecognized grades
        }
    }
        
        
}
