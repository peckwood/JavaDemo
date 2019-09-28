package com.bladespear.demo.multithreading.p6_wait_notify_demo_multi_prod_consu_improved_condition;

import java.util.Random;

public class Producer5 implements Runnable {
    private final IntegerQueue integerQueue;
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

    private void produce() throws InterruptedException {
        while (!integerQueue.isQueueFull()) {
            synchronized (integerQueue) {
                String threadName = Thread.currentThread().getName();
                System.out.println(String.format("\nProducer %s got lock", threadName));
            /*
            'while' is mandatory because 'if' only checks once,
                after which only spot might have been already been filled by another thread
                and it is trying to fill an full queue (imagine the it has max capacity)
             */
                boolean lostLock = false;
                while (integerQueue.isQueueFull()) {
                    System.out.println(String.format("Queue full, %s waits.", threadName));
                    lostLock = true;
                    integerQueue.wait();
                }
                if (lostLock) {
                    System.out.println(String.format("\nProducer %s has reacquired write lock", threadName));
                }
                integerQueue.getQueue().add(number);
                if (integerQueue.getQueue().size() == MAX_CAPACITY) {
                    integerQueue.setQueueFull(true);
                }
                System.out.println(String.format("%s produced %d, integerQueue: %s", threadName, number, integerQueue.getQueue()));
                number++;
                integerQueue.setQueueEmpty(false);
                integerQueue.notifyAll();
                System.out.println(String.format("Producer %s notified all", threadName));
            }
            Thread.sleep(random.nextInt(1000));
        }
    }

    public Producer5(IntegerQueue integerQueue, int MAX_CAPACITY) {
        this.integerQueue = integerQueue;
        this.MAX_CAPACITY = MAX_CAPACITY;
    }
}
