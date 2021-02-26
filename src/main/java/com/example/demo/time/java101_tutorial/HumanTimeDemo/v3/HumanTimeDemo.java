package com.example.demo.time.java101_tutorial.HumanTimeDemo.v3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class HumanTimeDemo
{
   public static void main(String[] args)
   {
      LocalDateTime localDateTime = LocalDateTime.now();
      System.out.printf("Date-time: %s%n", localDateTime);
      System.out.printf("Date-time: %s%n", localDateTime.withYear(2012));
      System.out.printf("Date-time: %s%n", localDateTime.minusWeeks(3));
//      System.out.printf("Date-time: %s%n", localDateTime.with(lastDayOfMonth()));
      LocalDate localDate = LocalDate.of(2010, 12, 1);
      LocalTime localTime = LocalTime.of(10, 15);
      localDateTime = localDateTime.with(localDate).with(localTime);
      System.out.printf("Date-time: %s%n", localDateTime);
   }
}