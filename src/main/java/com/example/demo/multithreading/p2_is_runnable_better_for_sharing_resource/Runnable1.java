package com.example.demo.multithreading.p2_is_runnable_better_for_sharing_resource;

public class Runnable1 implements Runnable{
    private int counter = 3;
    @Override
    public void run() {
        if(counter > 0){
            counter --;
        }
        System.out.println("Runnable1 counter: " + counter);
    }
}
