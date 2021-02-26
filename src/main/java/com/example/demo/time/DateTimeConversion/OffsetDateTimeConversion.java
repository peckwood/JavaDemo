package com.example.demo.time.DateTimeConversion;

import java.time.*;

public class OffsetDateTimeConversion{
    private static ZoneId zoneId = ZoneId.of("Asia/Shanghai");
    private static ZoneOffset zoneOffset = zoneId.getRules().getOffset(Instant.now());

    public void localDateTime2OffsetDateTime(LocalDateTime localDateTime){
        OffsetDateTime.of(localDateTime, zoneOffset);
    }

    public OffsetDateTime instantToOffsetDateTime(Instant instant){
        OffsetDateTime offsetDateTime = instant.atOffset(zoneOffset);
        return offsetDateTime;
    }
}
