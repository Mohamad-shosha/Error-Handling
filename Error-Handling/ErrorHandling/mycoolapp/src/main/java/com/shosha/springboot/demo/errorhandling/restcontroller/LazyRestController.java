package com.shosha.springboot.demo.errorhandling.restcontroller;

import com.shosha.springboot.demo.errorhandling.model.dto.StudentDto;
import com.shosha.springboot.demo.errorhandling.service.DbConnectionWithLazyImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Slf4j
@RestController
@RequestMapping("Lazy")
public class LazyRestController {

    private final DbConnectionWithLazyImpl dbConnectionWithLazyImpl;

    public LazyRestController(DbConnectionWithLazyImpl dbConnectionWithLazyImpl) {
        this.dbConnectionWithLazyImpl = dbConnectionWithLazyImpl;
    }

    @PostMapping("/AddStudent")
    public void addStudent(@Valid @RequestBody StudentDto studentDto) {
        dbConnectionWithLazyImpl.addStudent(studentDto);
    }

    @GetMapping("/GetStudent/{id}")
    public StudentDto getStudent(@PathVariable(value = "id") String key) {
        return dbConnectionWithLazyImpl.findAndGetStudentById(key);
    }

    @GetMapping("/GetStudents")
    public Collection<StudentDto> getStudents() {
        return dbConnectionWithLazyImpl.getStudents();
    }

    @PutMapping("/UpdateStudent/{id}")
    public void updateStudent(@Valid @RequestBody StudentDto studentDto, @PathVariable(value = "id") String key) {
        dbConnectionWithLazyImpl.findAndUpdateStudent(key,studentDto);
    }

    @DeleteMapping("/DeleteStudent")
    public void deleteStudent(@RequestParam(value = "id") String key) {
        dbConnectionWithLazyImpl.findAndDeleteStudentById(key);
    }

    @DeleteMapping("/DeleteStudentMap")
    public void deleteStudentMap() {
        dbConnectionWithLazyImpl.clear();
    }
}
