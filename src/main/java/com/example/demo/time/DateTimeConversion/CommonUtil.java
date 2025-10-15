package com.example.demo.time.DateTimeConversion;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class CommonUtil {
    public static LocalDateTime getLocalDateTime(){
        return LocalDateTime.now();
    }

    public static Instant getInstant(){
        return LocalDateTime.now().toInstant(getZoneOffset());
    }

    public static ZoneOffset getZoneOffset(){
        ZoneOffset zoneOffset = ZoneId.systemDefault().getRules().getOffset(Instant.now());
        return zoneOffset;
    }
}
