/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.Persona.Faculty.FacultyAssignment;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseOffer {

    Course course;
    ArrayList<Seat> seatlist;
    FacultyAssignment facultyassignment;
    private ArrayList<SeatAssignment> seatAssignments;

    public CourseOffer(Course c) {
        course = c;
        seatlist = new ArrayList<>();
        seatAssignments = new ArrayList<>(); // Initialize seatAssignments here
    }

    public ArrayList<SeatAssignment> getSeatAssignments() {
        return seatAssignments;
    }

    public void AssignAsTeacher(FacultyProfile fp) {
        if (fp != null) { // Ensure FacultyProfile is not null
            facultyassignment = new FacultyAssignment(fp, this);
        } else {
            System.out.println("Error: FacultyProfile is null. Cannot assign teacher.");
        }
    }

    public FacultyProfile getFacultyProfile() {
        if (facultyassignment != null) {
            return facultyassignment.getFacultyProfile();
        }
        return null; // Return null if facultyassignment is not set
    }

    public String getCourseNumber() {
        return course.getCOurseNumber();
    }

    public void generatSeats(int n) {
        for (int i = 0; i < n; i++) {
            seatlist.add(new Seat(this, i));
        }
    }

    public Seat getEmptySeat() {
        for (Seat s : seatlist) {
            if (!s.isOccupied()) {
                return s;
            }
        }
        return null;
    }

    public SeatAssignment assignEmptySeat(CourseLoad cl) {
        Seat seat = getEmptySeat();
        if (seat == null) {
            return null;
        }
        SeatAssignment sa = seat.newSeatAssignment(cl); // Seat is already linked to course offer
        seatAssignments.add(sa); // Add seat assignment to the list
        cl.registerStudent(sa); // Course offer seat is now linked to student
        return sa;
    }

    public int getTotalCourseRevenues() {
        int sum = 0;
        for (Seat s : seatlist) {
            if (s.isOccupied()) {
                sum += course.getCoursePrice();
            }
        }
        return sum;
    }

    public Course getSubjectCourse() {
        return course;
    }

    public int getCreditHours() {
        return course.getCredits();
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public FacultyAssignment getFacultyassignment() {
        return facultyassignment;
    }

    public void setFacultyassignment(FacultyAssignment facultyassignment) {
        this.facultyassignment = facultyassignment;
    }
}
