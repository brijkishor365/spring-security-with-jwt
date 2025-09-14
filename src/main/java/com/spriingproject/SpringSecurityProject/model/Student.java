package com.spriingproject.SpringSecurityProject.model;

import org.springframework.stereotype.Service;

/**
 * Model class representing a student entity.
 * This class contains basic student information including their ID,
 * name, and marks.
 *
 * @author BrijKishor
 * @version 1.0
 * @since 2025-09-14
 */
public class Student {
    /** The unique identifier for the student */
    private int id;
    
    /** The name of the student */
    private String name;
    
    /** The marks obtained by the student */
    private int marks;
    
    /**
     * Constructs a new Student with the specified details.
     *
     * @param id The student's unique identifier
     * @param name The student's name
     * @param marks The student's marks
     */
    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    /**
     * Gets the student's ID.
     *
     * @return The student's unique identifier
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the student's ID.
     *
     * @param id The unique identifier to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the student's name.
     *
     * @return The student's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the student's name.
     *
     * @param name The name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the student's marks.
     *
     * @return The student's marks
     */
    public int getMarks() {
        return marks;
    }

    /**
     * Sets the student's marks.
     *
     * @param marks The marks to set
     */
    public void setMarks(int marks) {
        this.marks = marks;
    }

    /**
     * Returns a string representation of the Student object.
     *
     * @return A string containing the student's id, name, and marks
     */
    @Override
    public String toString() {
        return "StudentController [id=" + id + ", name=" + name + ", marks=" + marks + "]";
    }
}
