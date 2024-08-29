package com.shosha.springboot.demo.errorhandling.error.exception;

import com.shosha.springboot.demo.errorhandling.util.TimingUtilities;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.sql.Timestamp;
/**
 *  
 * */
@EqualsAndHashCode(callSuper = true)
@Value
public class StudentExistException extends RuntimeException {
    Integer errorCode = 989;
    String errorMassage = "Student already exists";
    String errorDescription;
    Timestamp currentTimestamp;

    public StudentExistException(String errorDescription) {
        this.errorDescription = errorDescription;
        this.currentTimestamp = TimingUtilities.timestamp();

    }
}
