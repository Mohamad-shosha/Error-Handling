package com.luv2code.springboot.demo.designpattern.service;

import com.luv2code.springboot.demo.designpattern.error.exception.StudentNotFoundException;
import com.luv2code.springboot.demo.designpattern.model.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface DbConnectionService {
    void addStudent(StudentDto student);

    Collection<StudentDto> getStudents();

    StudentDto findStudentById(String id) throws StudentNotFoundException;

    void updateStudent(String id, StudentDto updatedStudentDto);

    void deleteStudentById(String id);

    int countStudents();

    void clear();
}
