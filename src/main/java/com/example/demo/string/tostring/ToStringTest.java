package com.example.demo.string.tostring;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ToStringTest{
    @Test
    public void showToString(){
        Map<String, Object> map = new HashMap<>();
        map.put("a", "b");
        System.out.println(map.toString());
    }
}
