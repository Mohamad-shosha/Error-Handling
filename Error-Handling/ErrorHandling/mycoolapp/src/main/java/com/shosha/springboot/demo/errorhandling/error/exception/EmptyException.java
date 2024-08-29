package com.shosha.springboot.demo.errorhandling.error.exception;

import com.shosha.springboot.demo.errorhandling.util.TimingUtilities;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.sql.Timestamp;

@Value
@EqualsAndHashCode(callSuper = true)
public class EmptyException extends RuntimeException {
     Integer code = 525;
     String message;
     String description;
     Timestamp currentTime;

    public EmptyException(String message, String description) {
        this.message = message;
        this.description = description;
        this.currentTime = TimingUtilities.timestamp();
    }

}
