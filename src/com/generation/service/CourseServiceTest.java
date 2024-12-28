package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {

    private CourseService courseService;                // create an instance of CourseService

    private StudentService studentService;              // create an instance of StudentService

    @BeforeEach
    void setUp() {
        courseService = new CourseService();
        studentService = new StudentService();
    }

    @AfterEach
    void tearDown() {                                   // reset all initialisation
    }

    @Test
    @DisplayName("getCourse operation worked.")
    void getCourse() {
        Course course = courseService.getCourse("INTRO-CS-1");
        assertEquals("INTRO-CS-1", course.getCode(), "Course code match.");
        assertNotEquals("INTRO-CS-10", course.getCode(), "Course code do not match.");
    }

    @Test
    @DisplayName("enrollStudent operation worked.")
    void enrollStudent() {
        Student student = studentService.findStudent("01");
        courseService.enrollStudent("INTRO-CS-1", student);
        List<Student> enrolledStudents = courseService.enrolledStudents.get("INTRO-CS-1");
        assertNotNull(enrolledStudents,"Enrolled student in this course should not be null.");
        assertEquals(1,enrolledStudents.size(),"Enrolled student in this course should be 1.");


    }


}