package com.bladespear.demo.multithreading.p3_wait_notify_demo_producer_consumer_bad_example;

import java.util.LinkedList;

public class Producer implements Runnable {

    private final LinkedList<Integer> integerQueue;

    @Override
    public void run() {
        synchronized (integerQueue) {
            int i = 1;
            while (true) {
                try {
                    if (integerQueue.size() == 4) {
                        integerQueue.notifyAll();
                        integerQueue.wait();
                    } else {
                        int number = i++;
                        integerQueue.add(number);
                        System.out.println("Producer added " + number);
                        Thread.sleep(1000);
                        integerQueue.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Producer(LinkedList<Integer> integerQueue) {
        this.integerQueue = integerQueue;
    }
}
