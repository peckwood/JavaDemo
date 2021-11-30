package com.example.demo.object;

import java.util.HashMap;
import java.util.Map;

public class ReferenceTest {
    public static void main(String[] args) {
        Map<Integer, Obj> map1 = new HashMap<>();
        map1.put(1, null);
        //obj指向null
        Obj obj = map1.get(1);
        //obj指向新的对象, map1里的还是null
        obj = new Obj();
        obj.setName("a");

        System.out.println("map1.get(1): " + map1.get(1));
        System.out.println("obj: " + obj);

        System.out.println("========================================================");

        Obj obj1 = new Obj();
        obj1.setName("b");
        map1.put(2, obj1);

        Obj obj2 = map1.get(2);
        obj2.setName("c");

        //obj1 和 obj2指向同一个对象
        System.out.println("map1.get(2): " + map1.get(2));
        System.out.println("obj1: " + obj1);
        System.out.println("obj2: " + obj2);
    }
}
