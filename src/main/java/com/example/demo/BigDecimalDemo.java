package com.example.demo;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

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

        //除法, 保留2位小数
        MathContext mathContext = new MathContext(2, RoundingMode.HALF_UP);
        BigDecimal wrongWay = new BigDecimal(20).divide(new BigDecimal(3), mathContext);
        BigDecimal quotient1 = new BigDecimal(20).divide(new BigDecimal(3), 2, RoundingMode.HALF_UP);
        System.out.println("wrongWay: " + wrongWay);
        System.out.println("quotient1: " + quotient1);

        //precision vs scale
        //scale: the number of digits to the right of the decimal point
        //precision: number of significant digits
        // https://stackoverflow.com/questions/3843440/bigdecimal-setscale-and-round
        BigDecimal precision = new BigDecimal("35.3456").round(new MathContext(4, RoundingMode.HALF_UP));
        BigDecimal scale = new BigDecimal("35.3456").setScale(4, RoundingMode.HALF_UP);
        System.out.println("precision: " + precision);
        System.out.println("scale: " + scale);

        System.out.println("格式化BigDeciaml https://jenkov.com/tutorials/java-internationalization/decimalformat.html");
        System.out.println("format1: " + new DecimalFormat("#0.##%").format(new BigDecimal("32.445")));
        System.out.println("format2: " + new DecimalFormat("0.##%").format(new BigDecimal("32.445")));


        System.out.println("format3: " + new DecimalFormat("#0.##%").format(new BigDecimal("0.005")));
        System.out.println("format4: " + new DecimalFormat("#.##%").format(new BigDecimal("0.005")));
        System.out.println("format5: " + new DecimalFormat("00.##%").format(new BigDecimal("0.005")));
        System.out.println("format6: " + new DecimalFormat("#.##%").format(new BigDecimal("0.34")));
        System.out.println("format7: " + new DecimalFormat("#.##%").format(new BigDecimal("0.3467")));
        System.out.println();
        System.out.println("format8: " + new DecimalFormat("0.##%").format(new BigDecimal("0.004")));
        System.out.println("format9: " + new DecimalFormat("#.##%").format(new BigDecimal("0.004")));

        // 百分号, 但是去掉后面的百分号
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setMultiplier(100);
        System.out.println("format10: " + decimalFormat.format(new BigDecimal("0.004")));

        //千分符
        System.out.println("format15: " + new DecimalFormat("###,###,###,##0.00").format(new BigDecimal("173680.06")));

        //默认展示
        System.out.println("format20: " + new BigDecimal("1736800000.06").toString());
    }
}
