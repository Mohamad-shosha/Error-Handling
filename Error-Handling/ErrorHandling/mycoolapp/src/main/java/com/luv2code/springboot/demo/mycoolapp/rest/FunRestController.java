package com.luv2code.springboot.demo.mycoolapp.rest;
import com.luv2code.springboot.demo.mycoolapp.designpattern.DbConnection;
import com.luv2code.springboot.demo.mycoolapp.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FunRestController {
  private final DbConnection dbConnection;
  @Autowired
  public FunRestController(DbConnection dbConnection){
    this.dbConnection = dbConnection;}

  @GetMapping("/AddStudent")
  public void addStudent(){
    Student student = new Student(3,"Karim",27);
    dbConnection.save(student);
  }
  @GetMapping("/AddStudents")
  public void addStudents (){
    Student [] student = {new Student(1,"mohamed",20),new Student(5,"Ahmed",40),new Student(3,"shosha",30)};
    List<Student> students = new ArrayList<>(Arrays.asList(student));
    dbConnection.addAll(students);
  }
  @GetMapping("/GetStudents")
  public List<Student> getStudents (){
    return dbConnection.getStudents();
  }

  @GetMapping("/GetStudent")
  public Student getStudent () {
    return dbConnection.getStudent(5);
  }

  @GetMapping("/UpdateStudent")
  public void updateStudent (){
    Student student = new Student(4,"Ebrahim",67);
    dbConnection.update(1,student);
  }

  @GetMapping("/DeleteStudent")
  public void deleteStudent (){
    dbConnection.delete(4);
  }

}
