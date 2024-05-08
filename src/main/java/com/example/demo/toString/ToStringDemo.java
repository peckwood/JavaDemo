package com.example.demo.toString;

import java.util.Arrays;
import java.util.HashMap;

public class ToStringDemo {
    public static void main(String[] args) {
        String[] a = {"aaa", "bbb"};
        System.out.println(Arrays.toString(a));

        HashMap<Object, Object> map = new HashMap<>();
        map.put("a", "aaa");
        map.put("b", "bbb");
        System.out.println(map);

    }
}
