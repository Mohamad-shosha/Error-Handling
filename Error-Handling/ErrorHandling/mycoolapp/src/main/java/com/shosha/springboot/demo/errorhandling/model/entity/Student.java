package com.shosha.springboot.demo.errorhandling.model.entity;

import com.shosha.springboot.demo.errorhandling.model.dto.AddressDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Slf4j
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String id ;
    private String name;
    private String email;
    private int age;
    private String phoneNumber;
    private AddressDto addressDto;

    @Autowired(required = false)
    public void setAddress(AddressDto addressDto) {
        this.addressDto = addressDto;
        if (Objects.nonNull(addressDto)) {
            log.info("Setter inject completely ");
        }
    }

}