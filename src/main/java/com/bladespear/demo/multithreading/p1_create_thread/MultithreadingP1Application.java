package com.bladespear.demo.multithreading.p1_create_thread;

import java.util.concurrent.*;

//4 ways to create a thread
public class MultithreadingP1Application {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        //继承Thread类
        Thread1 thread1 = new Thread1();
        thread1.start();

        //实现Runnable接口
        Thread thread2 = new Thread(new Runnable1());
        thread2.start();

        //实现Callable接口
        Callable1 callable1 = new Callable1();
        FutureTask<String> futureTask = new FutureTask<String>(callable1);
        Thread thread3 = new Thread(futureTask);
        thread3.start();
        //this will wait for thread3 to complete
        String result = futureTask.get();
        System.out.println(result);

        //使用Executor框架创建线程池来运行线程是推荐的运行线程的做法
        System.out.println("=================================================");
        int numOfThreads = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(numOfThreads);
        for (int i = 0; i < numOfThreads; i++) {
            executorService.execute(new Runnable1());
        }
        executorService.shutdown();

        System.out.println("=================================================");
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        Future future = executorService1.submit(new Callable1());
        System.out.println("is Callabl1 done after 10 milliseconds? " + future.isDone());
        System.out.println("Callable1 of executorService1 result: " +future.get());
        executorService1.shutdown();

    }
}
