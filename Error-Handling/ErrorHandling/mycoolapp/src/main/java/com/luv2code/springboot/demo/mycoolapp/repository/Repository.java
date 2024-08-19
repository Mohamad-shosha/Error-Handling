package com.luv2code.springboot.demo.mycoolapp.repository;

import com.luv2code.springboot.demo.mycoolapp.entity.Student;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class Repository {
    private Student student;
    private final List<Student> Students = new ArrayList<>();
    public void saveStudent (Student student){
        Students.add(student);
    }
    public void saveStudents (List<Student> students){
        Students.addAll(students);
    }

    public void updateStudent(Integer id, Student updatedStudent) {
        Student studentToUpdate = findStudentById(id);

        if (studentToUpdate != null) {
            // Update the student with the new information
            studentToUpdate.setId(updatedStudent.getId());
            studentToUpdate.setName(updatedStudent.getName());
            studentToUpdate.setAge(updatedStudent.getAge());
            // Add more fields as needed
        } else {
            // Handle case where no student with the given ID is found
            System.out.println("Student with ID " + id + " not found.");
        }
    }


    public void deleteStudent (Integer id){
        Student student = findStudentById(id);
        Students.remove(student);
    }

    public List<Student> findAll (){

        return Students;
    }

    public Student findStudentById(Integer id) {
        return Students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst() // Returns Optional<Student>
                .orElse(null); // Return null if no student found
    }
}
