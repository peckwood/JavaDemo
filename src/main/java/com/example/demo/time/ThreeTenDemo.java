package com.example.demo.time;

import org.threeten.bp.*;
import org.threeten.bp.temporal.ChronoUnit;

public class ThreeTenDemo {
    public static void main(String[] args) {
        LocalDateTime now1 = LocalDateTime.now();
        ZoneId zone = ZoneId.of("Asia/Shanghai");
        ZoneOffset zoneOffSet = zone.getRules().getOffset(now1);

        LocalDate date = LocalDate.of(2019, 7, 22);
        LocalDateTime dateTime = date.atStartOfDay();
        Instant monday = dateTime.toInstant(zoneOffSet);
        Instant now = Instant.now();

        long daysBetween = ChronoUnit.DAYS.between(monday, now);
        System.out.println(daysBetween);
    }
}
