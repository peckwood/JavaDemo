package com.example.demo.breakpoint;

import java.util.stream.Stream;

public class BreakpointTest2 {

    public static void main(String[] args) {
        // you can only choose the location of breakpoint in lambda
        Stream.iterate(0, i -> i + 1)
                .limit(100)
                .forEach(System.out::println);
        // you cannot set multiple breakpoints or choose the breakpoint location here
        System.out.println(1 > 0 ? 1+1 : 2+2);
    }
}
