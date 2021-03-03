package com.example.demo.varargs;

import java.util.Arrays;
import java.util.List;

public class VarargsTest{
    public static void main(String[] args){
        test(1, 2);
        Integer[] intArray = {3, 4};
        test(intArray);
        List<Integer> intList = Arrays.asList(intArray);
        // not working
//        test(intList);


    }

    public static void test(Integer... ints){
        // ints are treated as array
        for(Integer a: ints){
            System.out.println(a);
        }
    }
}
