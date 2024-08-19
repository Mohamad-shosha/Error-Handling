package com.luv2code.springboot.demo.designpattern.repository;

import com.luv2code.springboot.demo.designpattern.error.exception.StudentNotFoundException;
import com.luv2code.springboot.demo.designpattern.model.dto.StudentDto;
import com.luv2code.springboot.demo.designpattern.model.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Slf4j
@Component
public class StudentRepository implements StudentRepo {
    private final Student student;
    private final Map<String, Student> studentMap;

    @Autowired
    public StudentRepository(Student student) {
        this.student = student;
        studentMap = new HashMap<>();
    }

    @Override
    public void insertStudent(Student student) {
        studentMap.put(student.getId(), student);
    }

    @Override
    public Collection<Student> getStudents() {
        return studentMap.values();
    }


    @Override
    public Optional<Student> findStudentById(String id) {
        return studentMap.values()
                .stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    @Override
    public void deleteStudentById(String id) {
        studentMap.remove(id);
    }

    @Override
    public int countStudents() {
        return studentMap.size();
    }

    @Override
    public void clear() {
        studentMap.clear();
    }

}
