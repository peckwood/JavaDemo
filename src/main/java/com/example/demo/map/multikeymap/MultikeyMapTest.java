package com.example.demo.map.multikeymap;

import org.apache.commons.collections4.map.MultiKeyMap;

public class MultikeyMapTest {
    public static void main(String[] args) {
        MultiKeyMap<Integer, String> map = new MultiKeyMap<>();
        //前面的key必须都是同一类型
        map.put(1, 2, "12");
        System.out.println(map.get(1, 1));
    }


}
