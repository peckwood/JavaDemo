package com.example.demo.multithreading.reentrantlock;

public class SynchronizedLockExample implements Runnable{

    private Resource resource;

    public SynchronizedLockExample(Resource r){
        this.resource = r;
    }

    @Override
    public void run() {
        synchronized (resource) {
            resource.doSomething();
        }
        resource.doLogging();
    }
}