/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseCatalog;

import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.Department.Department;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseCatalog {
    private ArrayList<Course> courseList;
    Department department;
    String lastupdated;
    ArrayList<Course> courselist; 
    
    public CourseCatalog(Department d){
        courselist = new ArrayList();
        department = d;
        courseList = new ArrayList<>();
        initializePredefinedCourses();
    }
    private void initializePredefinedCourses() {
        // Add predefined courses here
        addPredefinedCourse("info 5100", "Introduction to Information Systems", 4);
        addPredefinedCourse("info 5200", "Database Management Systems", 4);
        addPredefinedCourse("info 5300", "Software Engineering", 4);
        addPredefinedCourse("info 5400", "Data Science Fundamentals", 4);
        addPredefinedCourse("info 5500", "Information Security", 4);
    }
    private void addPredefinedCourse(String number, String name, int credits) {
        Course course = new Course(name, number, credits);
        courselist.add(course);
    }
    public ArrayList<Course> getCourseList(){
        return courselist;
    }
    
    public Course newCourse(String n, String nm, int cr){
        Course c = new Course(n, nm, cr);
        courselist.add(c);
        return c;
    }
    
    public Course getCourseByNumber(String n){
        
        for( Course c: courselist){
            
            if(c.getCOurseNumber().equals(n)) return c;
        }
        return null;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    
      
     
}