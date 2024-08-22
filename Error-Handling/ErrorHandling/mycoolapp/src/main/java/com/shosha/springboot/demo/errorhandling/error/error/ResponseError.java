package com.shosha.springboot.demo.errorhandling.error.error;

import lombok.AllArgsConstructor;
import lombok.Value;
import java.sql.Timestamp;
@Value
@AllArgsConstructor
public class ResponseError {
    int code;
    String massage;
    String description;
    Timestamp currentTime;

    public ResponseError(int errorCount, String message, String detailMessageCode) {
        this.code = errorCount;
        this.massage = message;
        this.description = detailMessageCode;
        this.currentTime = new Timestamp(System.currentTimeMillis());
    }
}
