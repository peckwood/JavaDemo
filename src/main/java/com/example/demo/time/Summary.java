package com.example.demo.time;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class Summary {
    public static void main(String[] args) {
        //region OffsetDateTime

        //how to create OffsetDateTime
        ZoneOffset zoneOffset = ZoneOffset.of("+08:00");
        OffsetDateTime offsetDateTime = OffsetDateTime.now(zoneOffset);

        //endregion
    }
}
