package com.example.demo.map.myhashmap;

public class MyHashMapTest{
    public static void main(String[] args){
        MyHashMap<Integer, String> integerStringMyHashMap = new MyHashMap<>();
        integerStringMyHashMap.put(1, "A");
        integerStringMyHashMap.put(2, "B");
        integerStringMyHashMap.put(3, null);
        System.out.println("1: " + integerStringMyHashMap.get(1));
        System.out.println("2: " + integerStringMyHashMap.get(2));
        System.out.println("3: " + integerStringMyHashMap.get(3));

        integerStringMyHashMap.put(2, "D");
        System.out.println("2: " + integerStringMyHashMap.get(2));

        integerStringMyHashMap.put(3, "E");
        System.out.println("3: " + integerStringMyHashMap.get(3));

        integerStringMyHashMap.put(1, null);
        System.out.println("1: " + integerStringMyHashMap.get(1));


    }
}
