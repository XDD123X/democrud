package com.example.democrud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.democrud.Entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}