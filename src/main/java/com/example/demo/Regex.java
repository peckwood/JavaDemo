package com.example.demo;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex{
    public static void main(String[] args){
        String input = "http://192.168.1.253:18888/2021/03/11/896459e4-875f-455a-a2cb-768c879555e7.png";
        String regex = "http://[^/]+(.+)";
        matchRegex(regex, input);
        matchRegex("//fgcminiprogram//*", "/fgcminiprogram/aaa");
    }

    private static void matchRegex(String regex, String input){
        //Create a Pattern object
        Pattern pattern = Pattern.compile(regex);
        //Now create matcher object.
        Matcher matcher = pattern.matcher(input);
        if (matcher.find( )) {
            for (int i = 0; i < matcher.groupCount(); i++) {
                System.out.println(matcher.group(i));
            }
        } else {
            System.out.println("NO MATCH");
        }
    }

    @Test
    public void replaceAll() {
        String text1 = "错误信息:(20250515214350203)调用卡管服务出错:'社保卡补换卡:出错信息:ORA-20601:身份证有效起止日期相差必须为整数\n" +
                "        年STEAF_NEWLINORA-06512:在'KGL.BEFORE UPDATE CHECK AC01\", line186STEAF_NEWLINEORA-04088:触发器KGL.BEFORE_UPDATE_CHECK_AC01'执行\n" +
                "        过程中出错STEAF_NEWLINE'";
        String steafNewlin = text1.replaceAll("STEAF_NEWLINE", "<br />");
        System.out.println(steafNewlin);
    }
}
