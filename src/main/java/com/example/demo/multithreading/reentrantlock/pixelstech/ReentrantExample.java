package com.example.demo.multithreading.reentrantlock.pixelstech;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {
    private final ReentrantLock lock = new ReentrantLock();

    public void outer() {
        lock.lock();
        try {
            System.out.println("outer lock acquired");
            inner();
        } finally {
            lock.unlock();
            System.out.println("outer lock released");
        }
    }

    public void inner() {
        lock.lock();
        try {
            System.out.println("inner lock acquired");
        } finally {
            lock.unlock();
            System.out.println("inner lock released");
        }
    }

    public static void main(String[] args) {
        ReentrantExample example = new ReentrantExample();
        example.outer();
    }
}
