package com.bladespear.demo.multithreading.p7_wait_notify_demo_multi_prod_consu_lock_condition;

import java.util.LinkedList;
import java.util.concurrent.*;

public class MainClassP7 {
    public static void main(String[] args) throws InterruptedException {
        LinkedList<Integer> queue = new LinkedList<>();
        IntegerBlockingQueue integerQueue = new IntegerBlockingQueue(queue);
        int maxCapacity = 4;
        Producer7 producer = new Producer7(integerQueue);
        Consumer7 consumer = new Consumer7(integerQueue);

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
