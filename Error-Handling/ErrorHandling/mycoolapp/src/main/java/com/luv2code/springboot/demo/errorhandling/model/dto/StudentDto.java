
package com.luv2code.springboot.demo.errorhandling.model.dto;

import jakarta.validation.constraints.*;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Objects;
@Slf4j
@Component
public class StudentDto {
    @NonNull
    @Size(min = 2, max = 30, message = "Name is required and should be between 2 and 30 characters")
    private String name;
    @NotBlank(message = "Email is required")
    @NonNull
    @Email(message = "Email is not Valid")
    private String email;
    @NonNull
    @Min(value = 5, message = "Student is required and must be elder that 5 years")
    @Max(value = 10, message = "Student is required and must be younger that 10 years")
    private int age;

    private AddressDto addressDto;

    public StudentDto() {
    }

    public StudentDto(String name, String email, int age, AddressDto addressDto) {
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
        StudentDto that = (StudentDto) o;
        return age == that.age && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(addressDto, that.addressDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, age, addressDto);
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", address=" + addressDto +
                '}';
    }
}