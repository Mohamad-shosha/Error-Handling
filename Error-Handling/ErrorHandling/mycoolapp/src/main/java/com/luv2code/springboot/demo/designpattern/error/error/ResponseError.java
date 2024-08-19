package com.luv2code.springboot.demo.designpattern.error.error;

import lombok.Value;
import java.sql.Timestamp;
@Value
public class ResponseError {
    int code;
    String massage;
    String description;
    Timestamp currentTime;

}
