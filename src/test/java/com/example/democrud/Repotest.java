package com.example.democrud;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.democrud.Entity.Department;
import com.example.democrud.Entity.Instructor;
import com.example.democrud.Repository.DepartmentRepository;
import com.example.democrud.Repository.InstructorRepository;

@SpringBootTest
class Repotest {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    void save_instructor_success() {
        Department dept = new Department("IT", "HN");
        departmentRepository.save(dept);

        Instructor ins = new Instructor();
        ins.setFirstName("Nguyen");
        ins.setLastName("An");
        ins.setPhone("0123");
        ins.setDepartment(dept);

        Instructor saved = instructorRepository.save(ins);

        assertNotNull(saved.getId());

        Instructor fetched = instructorRepository.findById(saved.getId()).orElse(null);
        System.out.println("Fetched Instructor = " + fetched);

        assertNotNull(fetched);
    }
}
