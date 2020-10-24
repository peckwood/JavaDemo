package com.example.demo.multithreading.p2_is_runnable_better_for_sharing_resource;

import java.util.concurrent.Callable;

public class Callable1 implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("Callable1 is running, will return a String of 'Call'");
        return "Call";
    }
}
