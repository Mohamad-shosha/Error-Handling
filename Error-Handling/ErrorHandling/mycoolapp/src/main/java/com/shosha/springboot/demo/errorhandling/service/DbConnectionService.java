package com.shosha.springboot.demo.errorhandling.service;

import com.shosha.springboot.demo.errorhandling.error.exception.IsEmptyException;
import com.shosha.springboot.demo.errorhandling.error.exception.StudentNotFoundException;
import com.shosha.springboot.demo.errorhandling.model.dto.StudentDto;
import com.shosha.springboot.demo.errorhandling.model.entity.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface DbConnectionService {
    void addStudent(StudentDto student);

    Collection<StudentDto> getStudents();

    Student findStudentById(String id) throws StudentNotFoundException;

    StudentDto getStudentById(String id) throws StudentNotFoundException;

    void updateStudent(String id, StudentDto updatedStudentDto);

    void deleteStudentById(String id);

    int countStudents();

    void clear() throws IsEmptyException;
}
