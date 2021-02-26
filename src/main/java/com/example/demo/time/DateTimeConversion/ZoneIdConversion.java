package com.example.demo.time.DateTimeConversion;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class ZoneIdConversion{
    private static ZoneId zoneId = ZoneId.of("Asia/Shanghai");
    private static ZoneOffset zoneOffset = zoneId.getRules().getOffset(Instant.now());

}
