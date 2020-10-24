package com.example.demo.multithreading.p8_threadlocal_multi_prod_consu;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {
    private final String THREAD_NAME_PREFIX = "t";
    private int counter = 0;

    @Override
    public Thread newThread(Runnable runnable) {
        Thread thread  = new Thread(runnable, THREAD_NAME_PREFIX + ++counter);
        return thread;
    }
}
