package com.example.demo.map.to_string;

import java.util.HashMap;
import java.util.Map;


public class Demo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");

        System.out.println(map);
    }
}
