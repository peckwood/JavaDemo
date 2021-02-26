package com.example.demo.time.java101_tutorial.MachineTimeDemo.v1;

import java.time.Duration;
import java.time.Instant;

public class MachineTimeDemo
{
   public static void main(String[] args)
   {
      System.out.printf("EPOCH = %s%n", Instant.EPOCH);
      System.out.printf("MAX = %s%n", Instant.MAX);
      System.out.printf("MIN = %s%n", Instant.MIN);

      System.out.printf("Now = %s%n", Instant.now());
      System.out.printf("50 seconds past epoch = %s%n",
                        Instant.ofEpochSecond(50));
      System.out.printf("Parsed = %s%n",
                        Instant.parse("2007-12-03T10:15:30Z"));

      System.out.printf("ZERO = %s%n", Duration.ZERO);

      System.out.printf("30-second duration = %s%n",
                        Duration.ofSeconds(30));
      System.out.printf("Parsed = %s%n",
                        Duration.parse("PT3M20S"));     
   }
}