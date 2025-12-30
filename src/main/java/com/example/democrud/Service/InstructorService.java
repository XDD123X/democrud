package com.example.democrud.Service;

import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.democrud.Entity.Department;
import com.example.democrud.Entity.Instructor;
import com.example.democrud.Repository.DepartmentRepository;
import com.example.democrud.Repository.InstructorRepository;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;
    private final DepartmentRepository departmentRepository;

    public InstructorService(InstructorRepository instructorRepository, DepartmentRepository departmentRepository) {
        this.instructorRepository = instructorRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public Optional<Instructor> getInstructorById(Integer id) {
        return instructorRepository.findById(id);
    }

    public Instructor saveInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public Instructor updateInstructor(Integer id, Instructor instructor) {
        instructor.setId(id);
        return instructorRepository.save(instructor);
    }

    public void deleteInstructor(Integer id) {
        instructorRepository.deleteById(id);
    }

    public void deleteAllInstructors() {
        instructorRepository.deleteAll();
    }

    public List<Instructor> getInstructorsByDepartmentName(String departmentName) {
        return instructorRepository.findByDept(departmentName);
    }

    public void importInstructor(MultipartFile file) throws Exception {

        try (Workbook workbook = WorkbookFactory.create(file.getInputStream())) {

            Sheet sheet = workbook.getSheet("instructor");

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {

                Row row = sheet.getRow(i);
                if (row == null)
                    continue;

                String deptName = row.getCell(4).getStringCellValue();

                Department dept = departmentRepository.findById(deptName)
                        .orElseThrow(() -> new RuntimeException("Department not found: " + deptName));

                Instructor ins = new Instructor();
                ins.setFirstName(row.getCell(1).getStringCellValue());
                ins.setLastName(row.getCell(2).getStringCellValue());
                ins.setPhone(row.getCell(3).getStringCellValue());
                ins.setDepartment(dept);

                instructorRepository.save(ins);
            }
        }
    }

}