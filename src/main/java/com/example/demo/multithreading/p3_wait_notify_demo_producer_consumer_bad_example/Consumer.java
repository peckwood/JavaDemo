package com.example.demo.multithreading.p3_wait_notify_demo_producer_consumer_bad_example;

import java.util.LinkedList;

public class Consumer implements Runnable {
    private final LinkedList<Integer> integerQueue;

    @Override
    public void run() {
        synchronized (integerQueue) {
            while (true) {
                try {
                    if (integerQueue.isEmpty()) {
                        integerQueue.notifyAll();
                        integerQueue.wait();
                    } else {
                        Integer number = integerQueue.pop();
                        System.out.println("Consumer took " + number);
                        Thread.sleep(1000);
                        integerQueue.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public Consumer(LinkedList<Integer> integerQueue) {
        this.integerQueue = integerQueue;
    }
}
