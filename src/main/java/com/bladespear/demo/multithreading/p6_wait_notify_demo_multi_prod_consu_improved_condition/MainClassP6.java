package com.bladespear.demo.multithreading.p6_wait_notify_demo_multi_prod_consu_improved_condition;

import java.util.LinkedList;
import java.util.concurrent.*;

public class MainClassP6 {
    public static void main(String[] args) throws InterruptedException {
        LinkedList<Integer> queue = new LinkedList<>();
        IntegerQueue integerQueue = new IntegerQueue(queue);
        int maxCapacity = 4;
        Producer6 producer = new Producer6(integerQueue, maxCapacity);
        Consumer6 consumer = new Consumer6(integerQueue);

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
