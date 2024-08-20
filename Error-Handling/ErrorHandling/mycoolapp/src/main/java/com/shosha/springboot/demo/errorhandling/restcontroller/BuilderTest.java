package com.shosha.springboot.demo.errorhandling.restcontroller;

import com.shosha.springboot.demo.errorhandling.model.dto.AddressDto;

public class BuilderTest {
    public static void main(String[] args) {
        AddressDto addressDto =  AddressDto.builder()
                .setCountry("Egypt")
                .setCity("cairo")
                .build();
        System.out.println(addressDto);
    }
}
