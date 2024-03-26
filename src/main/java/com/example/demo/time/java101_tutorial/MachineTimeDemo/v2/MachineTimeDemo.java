package com.example.demo.time.java101_tutorial.MachineTimeDemo.v2;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;

public class MachineTimeDemo
{
   public static void main(String[] args)
   {
      Instant now = Instant.now();
      System.out.printf("Now = %s%n", now);
      System.out.printf("Epoch second = %d%n", now.getEpochSecond());
      System.out.printf("Nano = %d%n", now.getNano());
      System.out.printf("After epoch = %b%n", now.isAfter(Instant.EPOCH));
      System.out.printf("Before epoch = %b%n", now.isBefore(Instant.EPOCH));

      Duration dur = Duration.ofSeconds(49L-(long) (Math.random()*80));
      System.out.printf("Nano = %d%n", dur.getNano());
      System.out.printf("Seconds = %d%n", dur.getSeconds());
      System.out.printf("Is negative = %b%n", dur.isNegative());
      System.out.printf("Is zero = %b%n", dur.isZero());

      LocalTime start = LocalTime.of(8, 0);
      LocalTime end = LocalTime.of(9, 0);
      System.out.printf("Duration.between(start, end): %s%n", Duration.between(start, end));
      System.out.printf("duration.getSeconds: %s", Duration.between(start, end).getSeconds());
   }
}