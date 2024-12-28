package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student
    extends Person
    implements Evaluation
{
    private double average;

    private final List<Course> courses = new ArrayList<>();

    private final Map<String, Course> approvedCourses = new HashMap<>();

    public Student( String id, String name, String email, Date birthDate) {

        super( id, name, email, birthDate );
        average = 0.0;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public boolean enrollToCourse(Course course )
    {
        //TODO implement this method
        if (!approvedCourses.containsKey(course.getCode())) {               // if approvedCourse not found
            approvedCourses.put(course.getCode(), course);
        }
        return courses.add(course);                                     // add course to the student's course list

    }

    public void registerApprovedCourse( Course course ) {

        approvedCourses.put( course.getCode(), course );
    }

    public boolean isCourseApproved( String courseCode )
    {
        //TODO implement this method
        return approvedCourses.containsKey(courseCode);         // check if the course is approved
    }

    // CHALLENGE IMPLEMENTATION: Read README.md to find instructions on how to solve. 
    public List<Course> findPassedCourses( Course course )
    {
        //TODO implement this method
        return null;
    }

    public boolean isAttendingCourse( String courseCode )
    {
        //TODO implement this method
        for (Course course: courses) {                          // iterate through enrolled courses
            if(course.getCode().equals(courseCode)){            // check if courseCode matches
                return true;
            }
        }
        return false;
    }

    @Override
    public double getAverage()
    {
        return average;
    }

    @Override
    public List<Course> getApprovedCourses()
    {
        //TODO implement this method
        ArrayList<Course> approvedCourses = new ArrayList<>();
        boolean status = approvedCourses.addAll(this.approvedCourses.values());
        if(status == false){
            return null;
        }
        return approvedCourses;
    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }
}
