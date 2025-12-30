package com.example.democrud;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import com.example.democrud.Entity.Department;
import com.example.democrud.Entity.Instructor;
import com.example.democrud.Repository.DepartmentRepository;
import com.example.democrud.Repository.InstructorRepository;
import com.example.democrud.Service.InstructorService;

@SpringBootTest
class Repotest {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private InstructorService instructorService;

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

    @Test
    void import_excel_success() throws Exception {

        // 1. Tạo Department trước (FK)

        departmentRepository.save(new Department("Business", "HN"));
        departmentRepository.save(new Department("Design", "HN"));
        departmentRepository.save(new Department("IT", "HN"));

        // 2. Load file Excel test
        File file = new File("D:/spring project/democrud/sample_data.xlsx");

        MockMultipartFile multipartFile = new MockMultipartFile(
                "file",
                file.getName(),
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
                new FileInputStream(file));

        // 3. Gọi service
        instructorService.importInstructor(multipartFile);

        // 4. Verify
        List<Instructor> list = instructorRepository.findAll();
        assertFalse(list.isEmpty());
        System.out.println("=== START ===");
        list.forEach(System.out::println);
        System.out.println("=== END ===");

    }

    @Test
    void delete_all_instructors() {
        instructorService.deleteAllInstructors();
        List<Instructor> list = instructorRepository.findAll();
        assertTrue(list.isEmpty());
    }

}
