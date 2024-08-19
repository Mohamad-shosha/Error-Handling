package com.luv2code.springboot.demo.designpattern.repository;

import com.luv2code.springboot.demo.designpattern.error.exception.StudentNotFoundException;
import com.luv2code.springboot.demo.designpattern.model.dto.StudentDto;
import com.luv2code.springboot.demo.designpattern.model.entity.Student;


import java.util.Collection;
import java.util.Optional;

public interface StudentRepo {
    void insertStudent(Student student);

    Collection<Student> getStudents();

    Optional<Student> findStudentById(String id) ;

    void deleteStudentById(String id);

    int countStudents();

    void clear();

}
