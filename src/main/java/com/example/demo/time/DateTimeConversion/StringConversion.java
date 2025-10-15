package com.example.demo.time.DateTimeConversion;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class StringConversion {
    private static Logger logger = LoggerFactory.getLogger(StringConversion.class);

    @Test
    public void timeToString(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String string = now.format(formatter);
        System.out.println(string);
    }

    @Test
    public void instantToString(){
        Instant myInstant = Instant.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try {
            System.out.println(formatter.format(myInstant));
        } catch (Exception e) {
            logger.error("instant不能直接format, 会报错:", e);
        }

        //approach 1
        // you need to add zone for formatter:
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(CommonUtil.ZONE_ID);
        System.out.println(formatter2.format(myInstant));

        //approach 1
        // convert instant to ZonedDateTime
        ZonedDateTime zonedDateTime = myInstant.atZone(CommonUtil.ZONE_ID);
        System.out.println(formatter.format(zonedDateTime));

    }
}
