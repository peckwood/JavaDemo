package com.example.demo.time.DateTimeConversion;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class CommonUtil {

    public final static ZoneId ZONE_ID = ZoneId.of("Asia/Shanghai");
    public final static ZoneOffset ZONE_OFFSET = ZONE_ID.getRules().getOffset(Instant.now());

    public static LocalDateTime getLocalDateTime(){
        return LocalDateTime.now();
    }

    public static Instant getInstant(){
        return LocalDateTime.now().toInstant(ZONE_OFFSET);
    }
}
