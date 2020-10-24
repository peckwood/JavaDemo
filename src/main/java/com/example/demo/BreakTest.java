package com.example.demo;

public class BreakTest {
    public static void main(String[] args) {
        System.out.println(true && false || false && true);
        System.out.println(true && true || false && true);
        System.out.println(true && true || false && false);


        int[] a = {1, 2, 3, 5, 7};
        int[] b = {1, 5, 9};
        for(int bn : b){
            boolean found = false;
            for(int an : a){
                if(an == bn){
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println("not found: " + bn);

            }
        }
    }
}
