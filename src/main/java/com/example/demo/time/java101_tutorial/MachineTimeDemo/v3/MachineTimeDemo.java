package com.example.demo.time.java101_tutorial.MachineTimeDemo.v3;

import java.time.Duration;
import java.time.Instant;

public class MachineTimeDemo
{
   public static void main(String[] args)
   {
      Instant now = Instant.now();
      System.out.printf("Now = %s%n", now);
      System.out.printf("Now-20 seconds = %s%n", now.minusSeconds(20));
      System.out.printf("Now+500,000,000 nanoseconds = %s%n", now.plusNanos(500000000));

      Duration dur = Duration.ofDays(10);
      System.out.printf("Dur = %s%n", dur);
      System.out.printf("Dur/2 = %s%n", dur.dividedBy(2));
      System.out.printf("Dur-3 days = %s%n", dur.minusDays(3));
      System.out.printf("Dur*2 = %s%n", dur.multipliedBy(2));
      System.out.printf("Dur+12 hours = %s%n", dur.plusHours(12));
      System.out.printf("Dur nanos set to 500,000,000 = %s%n", dur.withNanos(500000000));
      System.out.printf("Dur seconds set to 3600 = %s%n", dur.withSeconds(3600));
   }
}