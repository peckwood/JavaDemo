package com.example.demo.multithreading.reentrantlock.openclassrooms_example;

public class Demo {
    public static void main(String[] args) {
        WordPrinterWithLocks wordPrinter = new WordPrinterWithLocks();
        Thread printerThread = new Thread(()->wordPrinter.printWord());
        printerThread.start();
        System.out.println(printerThread.getState());

        Thread setWordThread = new Thread(()->wordPrinter.setWordToPrint("Mars!"));
        setWordThread.start();

    }
}
