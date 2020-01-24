package com.example.demo.multithreading.p4_wait_notify_demo_producer_consumer1;

import java.util.LinkedList;
import java.util.Random;

public class Producer implements Runnable {

    private final LinkedList<Integer> integerQueue;
    private final int MAX_CAPACITY;
    private int number = 1;
    private Random random = new Random();

    @Override
    public void run() {
        int i = 1;
        while (true) {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Producer(LinkedList<Integer> integerQueue, int MAX_CAPACITY) {
        this.integerQueue = integerQueue;
        this.MAX_CAPACITY = MAX_CAPACITY;
    }

    private void produce() throws InterruptedException {
        synchronized (integerQueue) {
            while (integerQueue.size() == MAX_CAPACITY) {
                System.out.println("Queue full, Producer waits.");
                integerQueue.wait();
            }
            integerQueue.add(number);
            System.out.println(String.format("Produced %d, integerQueue: %s", number, integerQueue));
            number++;
            integerQueue.notifyAll();
        }
        Thread.sleep(random.nextInt(1000));
    }
}
