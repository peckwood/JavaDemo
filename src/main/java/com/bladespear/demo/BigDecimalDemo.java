package com.bladespear.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalDemo {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("99990");//单位为厘, 99.99元


        BigDecimal c = a.divide(new BigDecimal(2));
        System.out.println("c: " + c);

        //厘精确到分
        BigDecimal b = new BigDecimal(1000).divide(new BigDecimal(3), -1, RoundingMode.HALF_UP);
        System.out.println("b.longValue(): " + b.longValue());


        //厘精确到分: 13.92元
        BigDecimal e = new BigDecimal("13917.993");
        long e_long = e.setScale(-1, RoundingMode.HALF_UP).longValueExact();
        System.out.println(e_long);





    }
}