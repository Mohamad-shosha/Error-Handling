package com.luv2code.springboot.demo.errorhandling.error.exception;

import com.luv2code.springboot.demo.errorhandling.util.TimingUtilities;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.sql.Timestamp;
@EqualsAndHashCode(callSuper = true)
@Value
public class StudentNotFoundException extends RuntimeException {

    Integer errorCode = 100;
    String errorMassage = "Student with ID not found in the system.";
    String errorDescription;
    Timestamp currentTimestamp;

    public StudentNotFoundException(String errorDescription) {
        this.errorDescription = errorDescription;
        this.currentTimestamp = TimingUtilities.timestamp();

    }
}
