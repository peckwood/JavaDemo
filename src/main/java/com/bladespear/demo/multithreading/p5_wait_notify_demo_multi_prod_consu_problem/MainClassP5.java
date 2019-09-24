package com.bladespear.demo.multithreading.p5_wait_notify_demo_multi_prod_consu_problem;

import java.util.LinkedList;
import java.util.concurrent.*;

public class MainClassP5 {
    public static void main(String[] args) throws InterruptedException {
        LinkedList<Integer> queue = new LinkedList<>();
        int maxCapacity = 4;
        Producer5 producer = new Producer5(queue, maxCapacity);
        Consumer5 consumer = new Consumer5(queue);

        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(10);
        CustomThreadFactory customThreadFactory = new CustomThreadFactory();
        ExecutorService pool = new ThreadPoolExecutor(20, 40, 100, TimeUnit.SECONDS, workQueue, customThreadFactory);

        pool.execute(producer);
        pool.execute(producer);
        pool.execute(producer);
        pool.execute(producer);
        pool.execute(producer);

        pool.execute(consumer);
        pool.execute(consumer);
        pool.execute(consumer);
        pool.execute(consumer);
        pool.execute(consumer);
        Thread.sleep(5000);
    }
}
