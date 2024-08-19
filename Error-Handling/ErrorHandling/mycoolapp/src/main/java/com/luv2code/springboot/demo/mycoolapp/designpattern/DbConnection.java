package com.luv2code.springboot.demo.mycoolapp.designpattern;
import com.luv2code.springboot.demo.mycoolapp.entity.Student;
import com.luv2code.springboot.demo.mycoolapp.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import java.util.List;

@Component
public class DbConnection {

    // Eager instantiation
    private static final DbConnection instance = new DbConnection();
    private static Repository repository;
    private DbConnection(){

    }
    @Autowired
    public void setRepository (Repository repository){
        DbConnection.repository =repository;
    }

    public void save (Student student){
        repository.saveStudent(student);
    }
    public void addAll (List<Student> students ){
        repository.saveStudents(students);
    }

    public void delete (Integer id){
        repository.deleteStudent(id);
    }

    public void update (Integer id,Student student){
        repository.updateStudent(id,student);
    }

    public Student getStudent (Integer id ){
        return repository.findStudentById(id);
    }

    public List<Student> getStudents ( ){
        return repository.findAll();
    }
}
