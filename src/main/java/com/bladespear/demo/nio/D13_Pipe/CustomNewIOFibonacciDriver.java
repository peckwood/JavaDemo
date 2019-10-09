package com.bladespear.demo.nio.D13_Pipe;

import java.io.IOException;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomNewIOFibonacciDriver {
    public static void main(String[] args) throws IOException {
        Pipe pipe = Pipe.open();

        ReadableByteChannel source = pipe.source();
        WritableByteChannel sink = pipe.sink();

        CustomFibonacciProducerRunnable producer = new CustomFibonacciProducerRunnable(sink);
        CustomFibonacciConsumerRunnable consumer = new CustomFibonacciConsumerRunnable(source);

        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        ExecutorService pool = new ThreadPoolExecutor(2, 2, 5, TimeUnit.SECONDS, workQueue);
        pool.execute(producer);
        pool.execute(consumer);

    }
}
