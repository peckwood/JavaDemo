package com.example.demo.random;

import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceWithRandomNumber {
    public static void main(String[] args) {
        String text = "insert into VISUAL_DP02(ddp201, ddp202, aae140, aab301, aae001, aae707, aae036) values (seq_my_table_id.nextval, rand[1000000-9999999].rand[0-99], 110, 140500, 2015, 1, sysdate);\n";
        System.out.println(replaceRandomDecimal(replaceRandomNumbers(text)));
    }

    public static String replaceRandomNumbers(String text) {
        Pattern pattern = Pattern.compile("rand\\[(\\d+)-(\\d+)\\]");
        Matcher matcher = pattern.matcher(text);
        StringBuffer sb = new StringBuffer();

        while (matcher.find()) {
            int min = Integer.parseInt(matcher.group(1));
            int max = Integer.parseInt(matcher.group(2));
            if(min > max){
                System.out.println("min:" + min + " max:" + max);
            }
            int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
            matcher.appendReplacement(sb, String.valueOf(randomNum));
        }
        matcher.appendTail(sb);

        return sb.toString();
    }

    public static String replaceRandomDecimal(String text) {
        Pattern pattern = Pattern.compile("randdecimal(\\d+)\\[(\\d+)-(\\d+)\\]");
        Matcher matcher = pattern.matcher(text);
        StringBuffer sb = new StringBuffer();

        while (matcher.find()) {
            int numberOfDigits = Integer.parseInt(matcher.group(1));
            int min = Integer.parseInt(matcher.group(2));
            int max = Integer.parseInt(matcher.group(3));
            if(min > max){
                System.out.println("min:" + min + " max:" + max);
            }
            int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
            StringBuilder randomNumText = new StringBuilder(String.valueOf(randomNum));
            while(randomNumText.length() < numberOfDigits){
                System.out.printf("not enough decimal digits, inserting, randomNumText: %s, numberOfDigits: %d%n", randomNumText, numberOfDigits);
                randomNumText.insert(0, "0");
            }
            matcher.appendReplacement(sb, randomNumText.toString());
        }
        matcher.appendTail(sb);

        return sb.toString();
    }
}
