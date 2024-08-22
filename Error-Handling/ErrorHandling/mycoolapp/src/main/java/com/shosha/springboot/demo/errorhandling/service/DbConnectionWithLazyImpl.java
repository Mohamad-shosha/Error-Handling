package com.shosha.springboot.demo.errorhandling.service;

import com.shosha.springboot.demo.errorhandling.error.exception.IsEmptyException;
import com.shosha.springboot.demo.errorhandling.error.exception.StudentNotFoundException;
import com.shosha.springboot.demo.errorhandling.model.dto.StudentDto;
import com.shosha.springboot.demo.errorhandling.model.entity.Student;
import com.shosha.springboot.demo.errorhandling.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@Primary
public class DbConnectionWithLazyImpl implements DbConnectionService {
    private static DbConnectionWithLazyImpl instance;
    private final StudentRepository studentRepository;
    private final String className = StudentRepository.class.getSimpleName();

    public DbConnectionWithLazyImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void addStudent(StudentDto studentDto) {
        String id = UUID.randomUUID().toString();
        Student student = new Student(id, studentDto.getName(), studentDto.getEmail(),
                studentDto.getAge(), studentDto.getPhoneNumber(), studentDto.getAddressDto());
        studentRepository.insertStudent(student);
        log.info("The id of the new student is {} : ", id);
    }

    @Override
    public Student findStudentById(String id) throws StudentNotFoundException {
        StringBuilder methodName = new StringBuilder(className + ".findStudentById");
        log.info("Id of student that I will search with is: {}", id);
        Optional<Student> student = studentRepository.findStudentById(id);
        if (student.isPresent()) {
            Object[] parameters;
            parameters = new Object[]{methodName.toString(), id, student.get().getName(),
                    student.get().getEmail(), student.get().getAge(), student.get().getAddressDto()};
            log.info("{},I found id and his value is {}, Name of student is {},email is : {} ," +
                    " age is {} and his address is {} ", parameters);
        }

        return student.stream()
                .filter(element -> element.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found"));
    }

    @Override
    public Collection<StudentDto> getStudents() {
        return studentRepository.getStudents()
                .stream()
                .map(element -> new StudentDto(element.getName(), element.getEmail(),
                        element.getAge(), element.getPhoneNumber(), element.getAddressDto())).toList();
    }

    @Override
    public StudentDto getStudentById(String id) throws StudentNotFoundException {
        Student student = findStudentById(id);
        return new StudentDto(student.getName(), student.getEmail(),
                student.getAge(), student.getPhoneNumber(), student.getAddressDto());
    }

    @Override
    public void updateStudent(String id, StudentDto updatedStudent) {
        Student student = findStudentById(id);
        student.setName(updatedStudent.getName());
        student.setEmail(updatedStudent.getEmail());
        student.setAge(updatedStudent.getAge());
        student.setPhoneNumber(updatedStudent.getPhoneNumber());
        student.setAddressDto(updatedStudent.getAddressDto());
    }

    @Override
    public void deleteStudentById(String id) {
        Student student = findStudentById(id);
        studentRepository.deleteStudentById(id);
    }

    @Override
    public int countStudents() {
        return studentRepository.countStudents();
    }

    @Override
    public void clear() throws IsEmptyException {
        if (studentRepository.countStudents() > 0) {
            studentRepository.clear();
        } else {
            throw new IsEmptyException("No items to delete", "The map is empty");
        }
    }


}
