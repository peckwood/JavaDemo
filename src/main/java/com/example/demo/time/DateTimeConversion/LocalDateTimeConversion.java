package com.example.demo.time.DateTimeConversion;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class LocalDateTimeConversion{
    private static ZoneId zoneId = ZoneId.of("Asia/Shanghai");

    public LocalDateTime zonedDateTime2LocalDateTime(ZonedDateTime zonedDateTime){
        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
        return localDateTime;
    }

    public ZonedDateTime localDateTime2zonedDateTime(LocalDateTime localDateTime){
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        return zonedDateTime;
    }


}
