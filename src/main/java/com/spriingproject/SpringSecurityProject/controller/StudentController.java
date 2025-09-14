package com.spriingproject.SpringSecurityProject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spriingproject.SpringSecurityProject.model.Student;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Controller class handling student-related operations.
 * This controller provides endpoints for retrieving and adding student information,
 * as well as CSRF token management.
 *
 * @author BrijKishor
 * @version 1.0
 * @since 2025-09-14
 */
@RestController
public class StudentController {

    /** List storing student records */
    private List<Student> students = new ArrayList<>(List.of(
        new Student(1, "Brij Kishor", 88),
        new Student(2, "Amit", 70),
        new Student(3, "Vikas", 90)
    ));

    /**
     * Retrieves the list of all students.
     *
     * @return List of all students in the system
     */
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Retrieves the CSRF token for the current session.
     *
     * @param request The HTTP request object containing the CSRF token
     * @return The CSRF token for form submission protection
     */
    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    /**
     * Adds a new student to the system.
     *
     * @param student The student object to be added
     * @return The added student object
     */
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }
    
}
