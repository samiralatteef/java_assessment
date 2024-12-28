package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService
{
    private final Map<String, Student> students = new HashMap<>();

    public StudentService(){                                                                            // populate subscribeStudent
        subscribeStudent( new Student("01", "Anna", "anna@gmail.com", new Date("01/01/2000")));
        subscribeStudent( new Student("02", "Belle", "belle@gmail.com", new Date("02/02/2000")));

    }

    public void subscribeStudent( Student student ) {
        students.put( student.getId(), student );
    }

    public Student findStudent( String studentId )
    {
        if ( students.containsKey( studentId ) )
        {
            return students.get( studentId );
        }
        return null;
    }

    public boolean isSubscribed( String studentId )
    {
        //TODO implement this method
        if(students.containsKey(studentId)) {                       // Check if the student exist
        System.out.println("Student is subscribed.");
        return true;
    }else{
        System.out.println("Student is not subscribed.");
        return false;
    }
    }

    public void showSummary()                                       // show summary of students
    {
        //TODO implement
        System.out.println("Summary of students and enrolled courses:");
        for (String key: students.keySet()) {                       // iterate through students' key
            Student student = students.get(key);                    // get each student by its key
            System.out.println(student);                            // print the student retrieved from each key

            List<Course> courses = student.getApprovedCourses();

            if (courses == null){
                System.out.println("No enrolled courses");
            }else{
                for (Course course : courses){
                    System.out.println(course);
                }
            }

        }

    }

    public void enrollToCourse( String studentId, Course course )
    {
        if ( students.containsKey( studentId ) )
        {
            students.get( studentId ).enrollToCourse( course );
        }
    }


}
