package com.example.demo.nio.D13_Pipe;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;

public class CustomFibonacciConsumerRunnable implements Runnable {
    private ReadableByteChannel pipeSourceChannel;

    @Override
    public void run() {
        //both used for reading the count of numbers as well as each number's length
        ByteBuffer intBuffer = ByteBuffer.allocate(4);
        try {
            pipeSourceChannel.read(intBuffer);
            intBuffer.flip();
            //System.out.println("consumer intBuffer at beginning: " + intBuffer);
            //System.out.println("consumer intBuffer content at beginning: " + Arrays.toString(intBuffer.array()));
            int count = intBuffer.getInt();


            for (int i = 0; i < count; i++) {
                intBuffer.clear();
                pipeSourceChannel.read(intBuffer);

                intBuffer.flip();
                //System.out.println("consumer intBuffer: " + intBuffer);
                //System.out.println("consumer intBuffer content: " + Arrays.toString(intBuffer.array()));
                //will get BufferUnderflowException if you don't flip
                int length = intBuffer.getInt();

                ByteBuffer numberBuffer = ByteBuffer.allocate(length);
                pipeSourceChannel.read(numberBuffer);
                numberBuffer.flip();

                BigInteger number = new BigInteger(numberBuffer.array());
                System.out.println(i + ": " + number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                pipeSourceChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public CustomFibonacciConsumerRunnable(ReadableByteChannel pipeSourceChannel) {
        this.pipeSourceChannel = pipeSourceChannel;
    }
}
