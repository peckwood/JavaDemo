package com.example.demo.string.pad;

import org.junit.Test;

public class StringPadding {
    @Test
    public void padLeadingZero(){
        //填充为11位数字
        String string1 = String.format("%011d", 123);
        System.out.println(string1);
    }
}
