package com.shosha.springboot.demo.errorhandling.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    private final StudentProperties studentProperties;

    @Autowired
    public Config(StudentProperties studentProperties) {
        this.studentProperties = studentProperties;
    }

//    @Bean
//    public Address address() {
//        return new Address(
//                studentProperties.getAddress().getCountry(),
//                studentProperties.getAddress().getCity(),
//                studentProperties.getAddress().getStreet(),
//                studentProperties.getAddress().getBuildingNumber()
//        );
//    }
//
//    @Bean
//    public Student student() {
//        return new Student(studentProperties.getId(),studentProperties.getName(), studentProperties.getAge());
//    }
}