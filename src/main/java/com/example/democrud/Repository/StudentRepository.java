package com.example.democrud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.democrud.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}