package com.example.demo.multithreading.p2_is_runnable_better_for_sharing_resource;

import java.util.concurrent.*;

//4 ways to create a thread
public class MultithreadingP2Application {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //使用Executor框架创建线程池来运行线程是推荐的运行线程的做法
        int numOfThreads = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(numOfThreads);
        Runnable1 runnnable1 = new Runnable1();
        for (int i = 0; i < numOfThreads; i++) {
            executorService.execute(new Thread(runnnable1));
        }
        executorService.shutdown();

        ExecutorService executorService1 = Executors.newFixedThreadPool(numOfThreads);
        Thread thread1 = new Thread1();
        for (int i = 0; i < numOfThreads; i++) {
            executorService1.execute(new Thread(thread1));
        }
        executorService1.shutdown();

    }
}
