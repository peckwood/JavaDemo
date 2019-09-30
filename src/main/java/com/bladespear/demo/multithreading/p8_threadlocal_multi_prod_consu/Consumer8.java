package com.bladespear.demo.multithreading.p8_threadlocal_multi_prod_consu;

import java.util.LinkedList;
import java.util.Random;

public class Consumer8 implements Runnable {
    private final LinkedList<Integer> integerQueue;
    private Random random = new Random();
    ThreadLocal<String> threadName = new ThreadLocal<>();

    @Override
    public void run() {
        threadName.set(Thread.currentThread().getName());
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
        synchronized (integerQueue) {
            System.out.println(String.format("\nConsumer %s has lock", threadName.get()));
            /*
                'while' is mandatory because 'if' only checks once,
                after which only number might have been already popped by another
                and it is trying to pop from an empty queue
             */
            boolean lostLock = false;
            while (integerQueue.isEmpty()) {
                System.out.println(String.format("Queue empty, %s waits.", threadName.get()));
                lostLock = true;
                integerQueue.wait();
            }
            if(lostLock){
                System.out.println(String.format("\nConsumer %s has reacquired lock", threadName.get()));
            }
            Integer number = integerQueue.pop();
            System.out.println(String.format("%s consumed %d, integerQueue: %s", threadName.get(), number, integerQueue));
            integerQueue.notifyAll();
            System.out.println(String.format("Consumer %s notified All", threadName.get()));
        }
        Thread.sleep(random.nextInt(1000));
    }

    public Consumer8(LinkedList<Integer> integerQueue) {
        this.integerQueue = integerQueue;
    }
}
