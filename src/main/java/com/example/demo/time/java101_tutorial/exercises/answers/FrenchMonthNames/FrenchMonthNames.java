package com.example.demo.time.java101_tutorial.exercises.answers.FrenchMonthNames;

import java.time.Month;

import java.time.format.TextStyle;

import java.util.Locale;

public class FrenchMonthNames
{
   public static void main(String[] args)
   {
      Month[] months = Month.values();
      for (Month month: months)
         System.out.println(month.getDisplayName(TextStyle.FULL, 
                                                 Locale.FRENCH));
   }
}