package com.example.demo.compare_int_Integer;

public class CompareIntDemo {
    public static void main(String[] args) {
        int a = 1;
        Integer b = Integer.valueOf(1);
        Integer c = new Integer(1);

        //you can use == to compare Integer and int
        System.out.println("a == b: " + (a == b));
        //you can use equals to compare Integer and int
        System.out.println("b.equals(a): " + b.equals(1));
        System.out.println("c.equals(a): " + c.equals(a));

        System.out.println("b.equals(c)) " + b.equals(c));
        //the following line gives error for not using .equals()
        System.out.println("b==c: " + (b==c));

        //comparing values
        int d = 10;
        long e = 10L;
        System.out.println("d == e :" + (d ==  e));

        b = null;
        System.out.println("compare int with null: a == null: " + (a == b));


    }
}
