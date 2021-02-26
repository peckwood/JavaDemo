package com.example.demo.time.java101_tutorial.exercises.answers.ShowCalPage;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

import java.time.format.TextStyle;

import java.util.Locale;

import static java.time.DayOfWeek.*;

public class ShowCalPage
{
   public static void main(String[] args)
   {
      if (args.length < 2)
      {
         System.err.println("usage: java ShowCalPage yyyy mm [f|F]");
         return;
      }
      try
      {
         int year = Integer.parseInt(args[0]);
         int month = Integer.parseInt(args[1]);
         Locale locale = Locale.US;
         if (args.length == 3 && args[2].equalsIgnoreCase("f"))
            locale = Locale.FRANCE;
         showPage(year, month, locale);
      }
      catch (NumberFormatException nfe)
      {
         System.err.print(nfe);
      }
   }

   static void showPage(int year, int month, Locale locale)
   {
      if (month < 1 || month > 12)
         throw new IllegalArgumentException("month ["+month+"] out of "+
                                            "range [1, 12]");
      
      displayMonthAndYear(month, year, locale);
      displayWeekdayNames(locale);
      LocalDate localDate = LocalDate.of(year, month, 1);
      int daysInMonth = localDate.lengthOfMonth(); 
      int firstRowGap = localDate.getDayOfWeek().getValue(); // 7 = Sunday
      if (firstRowGap == 7)
         firstRowGap = 0;
      for (int i = 0; i < firstRowGap; i++)
         System.out.print("   ");
      for (int i = 1; i <= daysInMonth; i++)
      {
         if (i < 10)
            System.out.print(' ');
         System.out.print(i);
         if ((firstRowGap+i)%7 == 0)
            System.out.println();
         else
            System.out.print(' ');
      }
      System.out.println();
   }

   static void displayMonthAndYear(int month, int year, Locale locale)
   {
      System.out.println(Month.values()[month-1].getDisplayName(TextStyle.FULL,
                                                                locale)+" "+
                                                                year);
   }

   static void displayWeekdayNames(Locale locale)
   {
      DayOfWeek[] daysOfWeek = 
      {
         SUNDAY,
         MONDAY,
         TUESDAY,
         WEDNESDAY,
         THURSDAY,
         FRIDAY,
         SATURDAY
      };
      for (DayOfWeek dayOfWeek: daysOfWeek)
         System.out.print(dayOfWeek.getDisplayName(TextStyle.SHORT, 
                                                   locale).substring(0, 2)+" ");
      System.out.println();
   }
}