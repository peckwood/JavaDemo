package com.example.demo.multithreading.reentrantlock;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test2 {
    private int name;
    private static Map<String, ReentrantLock> lockMap = new ConcurrentHashMap<>();
    public void thread(String id) {
        ReentrantLock o = null;
        do {
            //开始执行先unlock
            if (o != null) {
                o.unlock();
            }
            o = lockMap.computeIfAbsent(id, k -> new ReentrantLock());
            //加锁
            o.lock();
            //新创建的被上一个线程remove掉了，或者新创建的对象和lockMap中已有的不是同一个对象，重试
        } while (lockMap.get(id) == null || o != lockMap.get(id));
        System.out.println(name + "-" + id + "进来了");
        try {
            //执行业务
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放锁
            lockMap.remove(id);
        }
        System.out.println(name + "-" + id + "走了");
    }

    public static void main(String[] args) {
        String id = "123";
        String id2 = "234";
        IntStream.rangeClosed(1, 10)
                .mapToObj(i -> {
                    return new Test2(i);
                }).forEach(t -> {
                    t.thread(id);
                    t.thread(id2);
                });


    }

    public Test2(int name) {
        this.name = name;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}
