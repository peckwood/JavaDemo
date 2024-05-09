package com.example.demo.multithreading.reentrantlock.pixelstech;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private final ReentrantLock lock = new ReentrantLock(); // 1.create ReentrantLock insatnce
    private int count = 0;

    public void increment() {
        lock.lock(); // 3.acquire lock
        try {
            count++;
            System.out.println("Current thread [" + Thread.currentThread().getName() + "] holds the lock, count = " + count
                    + ", hold count = " + lock.getHoldCount()); // 9.check current lock count for current thread
        } finally {
            lock.unlock(); // 4.release lock
        }
    }

    public void tryIncrement() {
        if (lock.tryLock()) { // 5.tries to acquire lock
            try {
                count++;
                System.out.println("Current thread [" + Thread.currentThread().getName() + "] holds the lock, count = " + count);
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Current thread [" + Thread.currentThread().getName() + "] failed to acquire the lock");
        }
    }

    public void tryIncrementWithTimeout() {
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) { // 6.tries to acquire lock within specified time
                try {
                    count++;
                    System.out.println("Current thread [" + Thread.currentThread().getName() + "] holds the lock, count = " + count);
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Current thread [" + Thread.currentThread().getName() + "] failed to acquire the lock");
            }
        } catch (InterruptedException e) {
            System.out.println("Current thread [" + Thread.currentThread().getName() + "] is interrupted");
        }
    }

    public void incrementInterruptibly() {
        try {
            lock.lockInterruptibly(); // 7.acquire lock with interruption
            try {
                count++;
                System.out.println("Current thread [" + Thread.currentThread().getName() + "] holds the lock, count = " + count);
            } finally {
                lock.unlock();
            }
        } catch (InterruptedException e) {
            System.out.println("Current thread [" + Thread.currentThread().getName() + "] is interrupted");
        }
    }

    public void printCount() {
        System.out.println("Current count = " + count);
    }
}
