package com.bladespear.demo.multithreading.p6_wait_notify_demo_multi_prod_consu_improved_condition;

import java.util.Random;

public class Consumer6 implements Runnable {
    private final IntegerQueue integerQueue;
    private final Random random = new Random();

    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consume() throws InterruptedException {

        while (!integerQueue.isQueueEmpty()) {
            synchronized (integerQueue) {
                //Note this is the only safe place to get current thread's name
                String threadName = Thread.currentThread().getName();
                System.out.println(String.format("\nConsumer %s got lock", threadName));
            /*
                'while' is mandatory because 'if' only checks once,
                after which only number might have been already popped by another
                and it is trying to pop from an empty queue
             */
                boolean lostLock = false;
                while (integerQueue.isQueueEmpty()) {
                    System.out.println(String.format("Queue empty, %s waits.", threadName));
                    lostLock = true;
                    integerQueue.wait();
                    Thread.sleep(500);
                }
                if (lostLock) {
                    System.out.println(String.format("\nConsumer %s has reacquired lock", threadName));
                }
                Integer number = integerQueue.getQueue().pop();
                if (integerQueue.getQueue().isEmpty()) {
                    integerQueue.setQueueEmpty(true);
                }
                System.out.println(String.format("%s consumed %d, integerQueue: %s", threadName, number, integerQueue.getQueue()));
                integerQueue.setQueueFull(false);
                integerQueue.notifyAll();
                System.out.println(String.format("Consumer %s notified all", threadName));
            }
        }
        Thread.sleep(random.nextInt(1000));
    }

    public Consumer6(IntegerQueue integerQueue) {
        this.integerQueue = integerQueue;
    }
}
