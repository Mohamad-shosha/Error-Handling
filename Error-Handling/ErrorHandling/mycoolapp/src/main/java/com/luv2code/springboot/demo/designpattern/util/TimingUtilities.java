package com.luv2code.springboot.demo.designpattern.util;

import java.sql.Timestamp;

public class TimingUtilities {
    public static Timestamp timestamp (){
        return new Timestamp(System.currentTimeMillis());
    }
}
