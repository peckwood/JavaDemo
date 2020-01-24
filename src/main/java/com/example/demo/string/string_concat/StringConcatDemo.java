package com.example.demo.string.string_concat;

import java.time.Duration;
import java.time.Instant;

public class StringConcatDemo {
    public static void main(String[] args) throws Exception {
        Instant start = Instant.now();
        String a = "";
        String b = "HELLOWORLD";
        int count = 50000;
        appendStringConcatenation(a, b, count);
        Instant end1 = Instant.now();
        System.out.println(Duration.between(start, end1).getSeconds());

        appendStringStringBuilder(a, b, count);
        Instant end2 = Instant.now();
        System.out.println(Duration.between(end1, end2).getSeconds());

    }
    private static void appendStringConcatenation(String a, String b, int count){
        for (int i = 0;i<count;i++){
            a = a + b;
        }
    }

    private static void appendStringStringBuilder(String a, String b, int count){
        StringBuilder aStringBuilder = new StringBuilder("a");
        for (int i = 0;i<count;i++){
            aStringBuilder.append(b);
        }
    }
}
