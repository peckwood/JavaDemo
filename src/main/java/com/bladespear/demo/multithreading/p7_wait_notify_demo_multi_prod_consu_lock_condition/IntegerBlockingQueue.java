package com.bladespear.demo.multithreading.p7_wait_notify_demo_multi_prod_consu_lock_condition;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IntegerBlockingQueue {
    private final int QUEUE_CAPACITY = 4;
    private final LinkedList<Integer> queue;
    private boolean queueFull = false;
    private boolean queueEmpty = true;
    private final Lock lock = new ReentrantLock();
    Condition QUEUE_NOT_FULL_CONDITION = lock.newCondition();
    Condition QUEUE_NOT_EMPTY_CONDITION = lock.newCondition();


    IntegerBlockingQueue(LinkedList queue) {
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

    /**
     * 阻塞添加新integer
     *
     * @param newInteger
     * @throws InterruptedException
     */
    public void blockingPut(Integer newInteger) throws InterruptedException {
        try {
            lock.lock();
            while (queue.size() == QUEUE_CAPACITY) {
                QUEUE_NOT_FULL_CONDITION.await();
            }
            System.out.println("Added ".concat(String.valueOf(newInteger)));
            queue.add(newInteger);
            showQueueContent();
            QUEUE_NOT_EMPTY_CONDITION.signalAll();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 阻塞移除元素
     *
     * @return
     */
    public Integer blockingTake() throws InterruptedException {
        try {
            lock.lock();
            while (queue.isEmpty()) {
                QUEUE_NOT_EMPTY_CONDITION.await();
            }
            Integer takeNumber = queue.pop();
            System.out.println("Took ".concat(String.valueOf(takeNumber)));
            showQueueContent();
            QUEUE_NOT_FULL_CONDITION.signalAll();
            return takeNumber;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            lock.unlock();
        }
    }

    public void showQueueContent() {
        System.out.println(queue + System.lineSeparator());
    }

}
