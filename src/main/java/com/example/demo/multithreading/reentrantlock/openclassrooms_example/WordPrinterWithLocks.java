package com.example.demo.multithreading.reentrantlock.openclassrooms_example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class WordPrinterWithLocks {
    ReentrantLock lock = new ReentrantLock();
    Condition readyToPrint = lock.newCondition();

    // Resources used for computation
    String wordToPrint;

    // Waits for a wordToPrint to be set
    public void printWord() {
        try {
            lock.lock();
            readyToPrint.await();
            System.out.println("The word is " + wordToPrint);
        } catch (InterruptedException e) {
        } finally {
            lock.unlock();
        }

    }

    // Sets a wordToPrint
    public void setWordToPrint(String wordToPrint) {
        try {
            lock.lock();
            this.wordToPrint = wordToPrint;
            readyToPrint.signal();
        } finally {
            lock.unlock();
        }
    }
}
