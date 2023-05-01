package com.example.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex{
    public static void main(String[] args){
        String input = "http://192.168.1.253:18888/2021/03/11/896459e4-875f-455a-a2cb-768c879555e7.png";
        String regex = "http://[^/]+(.+)";
        //Create a Pattern object
        Pattern pattern = Pattern.compile(regex);
        //Now create matcher object.
        Matcher matcher = pattern.matcher(input);
        if (matcher.find( )) {
            System.out.println("Found value: " + matcher.group(0) );
            System.out.println("Found value: " + matcher.group(1) );
            System.out.println("Found value: " + matcher.group(2) );
        } else {
            System.out.println("NO MATCH");
        }
    }
}
