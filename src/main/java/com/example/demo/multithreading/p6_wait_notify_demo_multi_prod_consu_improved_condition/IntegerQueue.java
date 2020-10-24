package com.example.demo.multithreading.p6_wait_notify_demo_multi_prod_consu_improved_condition;

import java.util.LinkedList;

public class IntegerQueue {
    private final LinkedList<Integer> queue;
    private boolean queueFull = false;
    private boolean queueEmpty = true;

    IntegerQueue(LinkedList queue) {
        this.queue = queue;
    }

    public LinkedList<Integer> getQueue() {
        return queue;
    }

    public boolean isQueueFull() {
        return queueFull;
    }

    public void setQueueFull(boolean queueFull) {
        this.queueFull = queueFull;
    }

    public boolean isQueueEmpty() {
        return queueEmpty;
    }

    public void setQueueEmpty(boolean queueEmpty) {
        this.queueEmpty = queueEmpty;
    }
}
