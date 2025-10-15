package com.example.demo.time.DateTimeConversion;

import org.junit.Test;

import java.time.*;

public class LocalDateConversion{
    @Test
    public void instant2LocalDate(){
        LocalDate localDate = CommonUtil.getInstant().atZone(CommonUtil.ZONE_ID).toLocalDate();
        System.out.println(localDate);
    }
}
