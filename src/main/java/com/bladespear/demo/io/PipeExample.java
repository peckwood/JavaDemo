package com.bladespear.demo.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        final PipedOutputStream out = new PipedOutputStream();
        final PipedInputStream in = new PipedInputStream(out);
        //you can also connect pipes with connect()
        //out.connect(in);
        //in.connect(out);

        Thread thread1 = new Thread(() -> {
            try {
                out.write("Hello Pipe!".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                int data = in.read();
                while(data != -1){
                    System.out.print((char)data);
                    data = in.read();
                }
                System.out.println();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        out.close();
        in.close();
    }
}
