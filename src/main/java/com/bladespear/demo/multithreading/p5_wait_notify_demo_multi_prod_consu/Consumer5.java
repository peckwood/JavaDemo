package com.bladespear.demo.multithreading.p5_wait_notify_demo_multi_prod_consu;

import java.util.LinkedList;
import java.util.Random;

public class Consumer5 implements Runnable {
    private final LinkedList<Integer> integerQueue;
    private Random random = new Random();

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
        synchronized (integerQueue) {
            if (integerQueue.isEmpty()) {
                System.out.println("Queue empty, Consumer waits.");
                integerQueue.wait();
            }
            Integer number = integerQueue.pop();
            System.out.println(String.format("Consumed %d, integerQueue: %s", number, integerQueue));
            integerQueue.notifyAll();
        }
        Thread.sleep(random.nextInt(1000));
    }

    public Consumer5(LinkedList<Integer> integerQueue) {
        this.integerQueue = integerQueue;
    }
}
