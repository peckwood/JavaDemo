package com.bladespear.demo.multithreading.p7_wait_notify_demo_multi_prod_consu_lock_condition;

import java.util.Random;

public class Consumer7 implements Runnable {
    private final IntegerBlockingQueue integerQueue;
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
        String threadName = Thread.currentThread().getName();
        //System.out.println(String.format("%s consumer is consuming", threadName));
        int number = integerQueue.blockingTake();
        //System.out.println(String.format("%s consumed %d, integerQueue: %s", threadName, number, integerQueue.getQueue()));
        Thread.sleep(random.nextInt(4000));
    }

    public Consumer7(IntegerBlockingQueue integerQueue) {
        this.integerQueue = integerQueue;
    }
}
