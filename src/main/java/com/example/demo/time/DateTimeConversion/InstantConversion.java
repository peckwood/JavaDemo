package com.example.demo.time.DateTimeConversion;

import java.time.*;

/**
 * ZonedDateTime = Instant + ZoneId
 */
public class InstantConversion{
    private static ZoneId zoneId = ZoneId.of("Asia/Shanghai");
    private static ZoneOffset zoneOffset = zoneId.getRules().getOffset(Instant.now());
    public static void main(String[] args){
        Instant instant = Instant.now();
    }

    public Long instantToEpochMilli(Instant instant){
        Long epochMilli =  instant.toEpochMilli();
        return epochMilli;
    }

    public LocalDateTime instantToLocalDateTime(Instant instant){
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        return localDateTime;
    }

    public ZonedDateTime instantToZonedDateTime1(Instant instant){
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, zoneId);
        return zonedDateTime;
    }

    public ZonedDateTime instantToZonedDateTime2(Instant instant){
        ZonedDateTime zonedDateTime =instant.atZone(zoneId);
        return zonedDateTime;
    }

    public Instant localDateTime2Instant(LocalDateTime localDateTime){
        Instant instant = localDateTime.toInstant(zoneOffset);
        return instant;
    }

    public Instant epochMilliToInstant(long epochMilli){
        Instant instant = Instant.ofEpochMilli(epochMilli);
        return instant;
    }

    public Instant zonedDateTimeToInstant1(ZonedDateTime zonedDateTime){
        Instant instant = zonedDateTime.toInstant();
        return instant;
    }

    public Instant zonedDateTimeToInstant2(ZonedDateTime zonedDateTime){
        Instant instant = Instant.from(zonedDateTime);
        return instant;
    }




}
