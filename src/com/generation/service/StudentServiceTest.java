package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Module;
import com.generation.model.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    private StudentService studentService = new StudentService();       // create an instance of StudentService


    @BeforeEach
    void setUp() {
        studentService = new StudentService();
    }

    @AfterEach
    void tearDown() {                                                  // reset all initialisation
    }

    @org.junit.jupiter.api.Test
    @DisplayName("isSubscribed operation worked.")
    void isSubscribed() {
        assertTrue(studentService.isSubscribed("01"));      // test to check whether student exist
        assertFalse(studentService.isSubscribed("05"));     // test to check whether student  does not exist
    }


    @org.junit.jupiter.api.Test
    @DisplayName("enrollToCourse operation worked.")
    void enrollToCourse() {
        Student student = new Student( "03", "lisa", "lisa@gmail.com", new Date("03/03/2000"));
        Course courseUnit = new Course("INTRO-UT-01", "Introduction to Unit Testing",9, null);
        student.enrollToCourse(courseUnit);
        assertTrue(student.isAttendingCourse("INTRO-UT-01"), "Student is enrolled in this course.");            // verify student is enrolled in this course
        assertFalse(student.isAttendingCourse("INTRO-UT-05"), "Student is not enrolled in this course.");       // verify student is not enrolled in this course
    }
}