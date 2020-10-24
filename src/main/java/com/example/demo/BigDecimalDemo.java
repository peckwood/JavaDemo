package com.example.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalDemo {
    public static void main(String[] args) {
        //单位为厘, 99.99元
        BigDecimal a = new BigDecimal("99990");

        BigDecimal c = a.divide(new BigDecimal(2));
        System.out.println("c: " + c);

        //厘精确到分
        BigDecimal b = new BigDecimal(1000).divide(new BigDecimal(3), -1, RoundingMode.HALF_UP);
        System.out.println("b.longValue(): " + b.longValue());


        //厘精确到分: 13.92元
        BigDecimal e = new BigDecimal("13917.993");
        long e_long = e.setScale(-1, RoundingMode.HALF_UP).longValueExact();
        System.out.println(e_long);

        //以50为精度, 向上取整 51>100
        System.out.println(Math.ceil(51/50.0)*50);
        BigDecimal toyPriceBigDecimal = new BigDecimal(51);
        long result = toyPriceBigDecimal.divide(new BigDecimal(50), 0, RoundingMode.CEILING).multiply(new BigDecimal(50)).longValueExact();
        System.out.println("以50为精度, 向上取整 51 > "+result);



    }
}
