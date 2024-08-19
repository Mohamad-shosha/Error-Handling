package com.luv2code.springboot.demo.errorhandling.model.entity;

import com.luv2code.springboot.demo.errorhandling.model.dto.AddressDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Slf4j
@Component
public class Student {
    private String id;
    private String name;
    private String email;
    private int age;
    private AddressDto addressDto;

    public Student() {
    }

    public Student(String id, String name, String email, int age, AddressDto addressDto) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.addressDto = addressDto;
    }


    @Autowired(required = false)
    public void setAddress(AddressDto addressDto) {
        this.addressDto = addressDto;
        if (Objects.nonNull(addressDto)) {
            log.info("Setter inject completely ");
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public AddressDto getAddress() {
        return addressDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(email, student.email) && Objects.equals(addressDto, student.addressDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, age, addressDto);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", address=" + addressDto +
                '}';
    }

}