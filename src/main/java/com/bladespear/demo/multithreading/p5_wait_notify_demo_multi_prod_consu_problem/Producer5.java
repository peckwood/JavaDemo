package com.bladespear.demo.multithreading.p5_wait_notify_demo_multi_prod_consu_problem;

import java.util.LinkedList;
import java.util.Random;

public class Producer5 implements Runnable {
    private final LinkedList<Integer> integerQueue;
    private final int MAX_CAPACITY;
    private int number = 1;
    private Random random = new Random();

    @Override
    public void run() {
        while (true) {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Producer5(LinkedList<Integer> integerQueue, int MAX_CAPACITY) {
        this.integerQueue = integerQueue;
        this.MAX_CAPACITY = MAX_CAPACITY;
    }

    private void produce() throws InterruptedException {
        synchronized (integerQueue) {
            String threadName = Thread.currentThread().getName();
            System.out.println(String.format("\nProducer %s has lock", threadName));
            /*
            'while' is mandatory because 'if' only checks once,
                after which only spot might have been already been filled by another thread
                and it is trying to fill an full queue (imagine the it has max capacity)
             */
            boolean lostLock = false;
            while (integerQueue.size() >= MAX_CAPACITY) {
                System.out.println(String.format("Queue full, %s waits.", threadName));
                lostLock = true;
                integerQueue.wait();
            }
            if(lostLock){
                System.out.println(String.format("\nProducer %s has reacquired lock", threadName));
            }
            integerQueue.add(number);
            System.out.println(String.format("%s produced %d, integerQueue: %s", threadName, number, integerQueue));
            number++;
            integerQueue.notifyAll();
            System.out.println(String.format("Producer %s notifiedAll", threadName));
        }
        Thread.sleep(random.nextInt(1000));
    }
}
