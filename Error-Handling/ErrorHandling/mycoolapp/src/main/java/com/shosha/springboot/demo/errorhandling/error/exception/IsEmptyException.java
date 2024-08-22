package com.shosha.springboot.demo.errorhandling.error.exception;

import com.shosha.springboot.demo.errorhandling.util.TimingUtilities;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Value
public class IsEmptyException extends RuntimeException {
     Integer code = 525;
     String message;
     String description;
     Timestamp currentTime;

    public IsEmptyException(String message, String description) {
        this.message = message;
        this.description = description;
        this.currentTime = TimingUtilities.timestamp();
    }

}
