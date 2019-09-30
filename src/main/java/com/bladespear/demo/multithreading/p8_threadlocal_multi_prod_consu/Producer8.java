package com.bladespear.demo.multithreading.p8_threadlocal_multi_prod_consu;

import java.util.LinkedList;
import java.util.Random;

public class Producer8 implements Runnable {
    private final LinkedList<Integer> integerQueue;
    private final int MAX_CAPACITY;
    private int number = 1;
    private Random random = new Random();
    private ThreadLocal<String> threadName = new ThreadLocal<>();

    @Override
    public void run() {
        threadName.set(Thread.currentThread().getName());
        while (true) {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Producer8(LinkedList<Integer> integerQueue, int MAX_CAPACITY) {
        this.integerQueue = integerQueue;
        this.MAX_CAPACITY = MAX_CAPACITY;
    }

    private void produce() throws InterruptedException {
        synchronized (integerQueue) {
            System.out.println(String.format("\nProducer %s has lock", threadName.get()));
            /*
            'while' is mandatory because 'if' only checks once,
                after which only spot might have been already been filled by another thread
                and it is trying to fill an full queue (imagine the it has max capacity)
             */
            boolean lostLock = false;
            while (integerQueue.size() >= MAX_CAPACITY) {
                System.out.println(String.format("Queue full, %s waits.", threadName.get()));
                lostLock = true;
                integerQueue.wait();
            }
            if(lostLock){
                System.out.println(String.format("\nProducer %s has reacquired lock", threadName.get()));
            }
            integerQueue.add(number);
            System.out.println(String.format("%s produced %d, integerQueue: %s", threadName.get(), number, integerQueue));
            number++;
            integerQueue.notifyAll();
            System.out.println(String.format("Producer %s notifiedAll", threadName.get()));
        }
        Thread.sleep(random.nextInt(1000));
    }
}
