package com.example.demo.primitive_data_type.integer.autoboxing;

public class CompareAutoboxedIntegers{
    public static void main(String[] args){
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;
        System.out.println( i1 == i2);
        /*
        the method Integer.valueOf()
        returns a cached instance if the value is inside -128~127
        or returns a new object
        to yield significantly better space and time performance by
        caching frequently requested values.
        reference: https://blog.csdn.net/hejiajiaming/article/details/76781200 (Chinese)

        YOU SHOULD USE equals to compare Integers, though
         */
        System.out.println( i3 == i4);
    }
}
