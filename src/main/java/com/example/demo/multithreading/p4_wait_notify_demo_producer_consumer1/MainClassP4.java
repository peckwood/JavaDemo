package com.example.demo.multithreading.p4_wait_notify_demo_producer_consumer1;

import java.util.LinkedList;
import java.util.concurrent.*;

public class MainClassP4 {
    /**
     * 启发: https://howtodoinjava.com/java/multi-threading/wait-notify-and-notifyall-methods/
     * @param args
     */
    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();
        Producer producer = new Producer(queue, 4);
        Consumer consumer = new Consumer(queue);

        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(10);
        ExecutorService pool = new ThreadPoolExecutor(2, 4, 5, TimeUnit.SECONDS, workQueue);

        pool.execute(consumer);
        pool.execute(producer);
    }
}
