package com.example.demo.time;

import java.time.*;

public class DateTimeConversion {
    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        Instant instant = Instant.now();
        //time milliseconds since January 1, 1970, 00:00:00 GMT.
        long epochMilli = instant.toEpochMilli();
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        ZoneOffset zoneOffset = ZoneOffset.of("+08:00");


        //Instant to LocalDateTime
        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        //epochMilli to Instant
        Instant instant1 = Instant.ofEpochMilli(epochMilli);

        //Instant to epochMilli
        long epochchMilli1 = instant.toEpochMilli();
        System.out.println();

        //ZonedDateTime to Instant
        Instant instant2 = zonedDateTime.toInstant();

        //Instant to ZonedDateTime
        //1
        ZonedDateTime.ofInstant(instant2, zoneId);
        //2
        instant2.atZone(zoneId);

        //ZonedDateTime to LocalDate
        LocalDate localDate = zonedDateTime.toLocalDate();

        //ZonedDateTime to LocalDateTime
        LocalDateTime localDateTime2 = zonedDateTime.toLocalDateTime();

        //LocalDateTime to ZonedDateTime
        ZonedDateTime zonedDateTime1 = localDateTime.atZone(zoneId);


        //LocalDateTime to OffsetDateTime
        OffsetDateTime offsetDateTime = localDateTime.atOffset(zoneOffset);

        //Instant to OffsetDateTime
        instant2.atOffset(zoneOffset);


        System.out.println();

    }
}
