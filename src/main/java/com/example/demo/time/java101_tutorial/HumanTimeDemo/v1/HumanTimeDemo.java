package com.example.demo.time.java101_tutorial.HumanTimeDemo.v1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class HumanTimeDemo
{
   public static void main(String[] args)
   {
      // create from current date
      LocalDate localDate = LocalDate.now();
      System.out.printf("Local date = %s%n", localDate);

      // create from specific values
      localDate = LocalDate.of(2012, 12, 21);
      System.out.printf("Local date = %s%n", localDate);

      // create from 100 days into 1970
      localDate = LocalDate.ofEpochDay(100);
      System.out.printf("Local date = %s%n", localDate);
      
      // create from another local date
      localDate = LocalDate.from(localDate);
      System.out.printf("Local date = %s%n%n", localDate);


      // create from current time
      LocalTime localTime = LocalTime.now();
      System.out.printf("Local time = %s%n", localTime);

      // create from specific values
      localTime = LocalTime.of(9, 15);
      System.out.printf("Local time = %s%n", localTime);

      // create from 120 seconds past midnight
      localTime = LocalTime.ofSecondOfDay(120);
      System.out.printf("Local time = %s%n", localTime);

      // create from another local time
      localTime = LocalTime.from(localTime);
      System.out.printf("Local time = %s%n%n", localTime);


      // create from current date and time
      LocalDateTime localDateTime = LocalDateTime.now();
      System.out.printf("Local date and time = %s%n", localDateTime);
   }
}