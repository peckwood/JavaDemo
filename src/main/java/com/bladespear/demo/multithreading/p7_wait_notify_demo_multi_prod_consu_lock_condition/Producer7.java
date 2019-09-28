package com.bladespear.demo.multithreading.p7_wait_notify_demo_multi_prod_consu_lock_condition;

import java.util.Random;

public class Producer7 implements Runnable {
    private final IntegerBlockingQueue integerQueue;
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
        String threadName = Thread.currentThread().getName();
        //System.out.println(String.format("%s producer is producing", threadName));
        int number = random.nextInt(100);
        integerQueue.blockingPut(number);
        //System.out.println(String.format("%s produced %d, integerQueue: %s", threadName, number, integerQueue.getQueue()));
        Thread.sleep(random.nextInt(4000));
    }

    public Producer7(IntegerBlockingQueue integerQueue) {
        this.integerQueue = integerQueue;
    }
}
