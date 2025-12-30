package com.example.democrud.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Course", schema = "dbo")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "departmentName")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "instructorID")
    private Instructor instructor;

    @ManyToMany
    @JoinTable(name = "course_student", joinColumns = @JoinColumn(name = "courseID"), inverseJoinColumns = @JoinColumn(name = "studentID"))
    private List<Student> students;

    public Course() {
    }

    public Course(String name, Integer duration, Department department, Instructor instructor) {
        this.name = name;
        this.duration = duration;
        this.department = department;
        this.instructor = instructor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
