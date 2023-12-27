package com.example.demo.time.DateTimeConversion;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringConversion {
    @Test
    public void timeToString(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String string = now.format(formatter);
        System.out.println(string);
    }
}
