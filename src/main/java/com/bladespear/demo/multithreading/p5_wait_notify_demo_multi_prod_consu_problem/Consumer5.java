package com.bladespear.demo.multithreading.p5_wait_notify_demo_multi_prod_consu_problem;

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
        //Note this is the only safe place to get current thread's name
        String threadName = Thread.currentThread().getName();
        synchronized (integerQueue) {
            System.out.println(String.format("\nConsumer %s has lock", threadName));
            /*
                'while' is mandatory because 'if' only checks once,
                after which only number might have been already popped by another
                and it is trying to pop from an empty queue
             */
            boolean lostLock = false;
            while (integerQueue.isEmpty()) {
                System.out.println(String.format("Queue empty, %s waits.", threadName));
                lostLock = true;
                integerQueue.wait();
            }
            if(lostLock){
                System.out.println(String.format("\nConsumer %s has reacquired lock", threadName));
            }
            Integer number = integerQueue.pop();
            System.out.println(String.format("%s consumed %d, integerQueue: %s", threadName, number, integerQueue));
            integerQueue.notifyAll();
            System.out.println(String.format("Consumer %s notified All", threadName));
        }
        Thread.sleep(random.nextInt(1000));
    }

    public Consumer5(LinkedList<Integer> integerQueue) {
        this.integerQueue = integerQueue;
    }
}
