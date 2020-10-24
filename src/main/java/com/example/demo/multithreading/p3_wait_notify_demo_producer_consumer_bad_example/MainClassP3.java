package com.example.demo.multithreading.p3_wait_notify_demo_producer_consumer_bad_example;

import java.util.LinkedList;
import java.util.concurrent.*;

public class MainClassP3 {
    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue(10);
        ExecutorService pool = new ThreadPoolExecutor(2, 4, 5, TimeUnit.SECONDS, workQueue);

        pool.execute(consumer);
        pool.execute(producer);
    }
}
