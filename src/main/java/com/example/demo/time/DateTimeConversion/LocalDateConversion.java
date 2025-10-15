package com.example.demo.time.DateTimeConversion;

import org.junit.Test;

import java.time.*;

public class LocalDateConversion{
    private static ZoneId zoneId = ZoneId.of("Asia/Shanghai");

    @Test
    public void instant2LocalDate(){
        LocalDate localDate = CommonUtil.getInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println(localDate);
    }
}
