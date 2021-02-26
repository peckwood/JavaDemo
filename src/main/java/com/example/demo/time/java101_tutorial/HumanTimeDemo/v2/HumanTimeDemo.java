package com.example.demo.time.java101_tutorial.HumanTimeDemo.v2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class HumanTimeDemo
{
   public static void main(String[] args)
   {
      LocalDateTime localDateTime = LocalDateTime.now();
      System.out.printf("Date-time: %s%n", localDateTime);
      System.out.printf("Day of year: %d%n", localDateTime.getDayOfYear());
      LocalDate localDate = localDateTime.toLocalDate();
      LocalTime localTime = localDateTime.toLocalTime();
      System.out.printf("Date: %02d-%02d-%02d%n", localDate.getYear(),
                        localDate.getMonthValue(), localDate.getDayOfMonth());
      System.out.printf("Time: %02d:%02d:%-2d%n", localTime.getHour(),
                        localTime.getMinute(), localTime.getSecond());
   }
}