package com.shosha.springboot.demo.errorhandling.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;
@NoArgsConstructor
@Component
public class AddressDto {
    @NotBlank(message = "Country is required")
    @Size(min = 2, max = 50, message = "Country must be between 2 and 50 characters")
    String country;

    @NotBlank(message = "City is required")
    @Size(min = 2, max = 50, message = "City must be between 2 and 50 characters")
    String city;

    @NotBlank(message = "Street is required")
    @Size(min = 2, max = 100, message = "Street must be between 2 and 100 characters")
    String street;

    @Min(value = 1, message = "Building number must be greater than 0")
    int buildingNumber;

    @NotBlank(message = "Street is required")
    @Size(min = 2, max = 100, message = "Street must be between 2 and 100 characters")
    String zipcode;

    public AddressDto(AddressDtoBuilder builder) {
        this.country = builder.country;
        this.city = builder.city;
        this.street = builder.street;
        this.buildingNumber = builder.buildingNumber;
        this.zipcode = builder.zipcode;
    }

    public static class AddressDtoBuilder {
        String country;
        String city;
        String street;
        int buildingNumber;
        String zipcode;

        public AddressDtoBuilder setCountry(String country) {
            this.country = country;
            return this;
        }

        public AddressDtoBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public AddressDtoBuilder setStreet(String street) {
            this.street = street;
            return this;
        }

        public AddressDtoBuilder setBuildingNumber(int buildingNumber) {
            this.buildingNumber = buildingNumber;
            return this;
        }

        public AddressDtoBuilder setZipcode(String zipcode) {
            this.zipcode = zipcode;
            return this;
        }

        public AddressDto build() {
            return new AddressDto(this);
        }

    }

    public static AddressDtoBuilder builder() {
        return new AddressDtoBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDto addressDto = (AddressDto) o;
        return buildingNumber == addressDto.buildingNumber && Objects.equals(country, addressDto.country) && Objects.equals(city, addressDto.city) && Objects.equals(street, addressDto.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city, street, buildingNumber);
    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", buildingNumber=" + buildingNumber +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}