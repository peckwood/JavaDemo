package com.bladespear.demo.multithreading.p8_threadlocal_multi_prod_consu;

import java.util.LinkedList;
import java.util.concurrent.*;

public class MainClassP8 {
    public static void main(String[] args) throws InterruptedException {
        LinkedList<Integer> queue = new LinkedList<>();
        int maxCapacity = 4;
        Producer8 producer = new Producer8(queue, maxCapacity);
        Consumer8 consumer = new Consumer8(queue);

        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(80);
        CustomThreadFactory customThreadFactory = new CustomThreadFactory();
        ExecutorService pool = new ThreadPoolExecutor(10, 20, 100, TimeUnit.SECONDS, workQueue, customThreadFactory);

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

        //guess how many what will 'workQueue.size()' print?
//        for(int i =0 ;i<50;i++){
//            pool.execute(producer);
//            pool.execute(consumer);
//        }
//        System.out.println(workQueue.size());
    }
}
