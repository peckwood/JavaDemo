package com.example.demo.nio.D13_Pipe;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.List;

public class CustomFibonacciProducerRunnable implements Runnable{
    private WritableByteChannel pipeSinkChannel;
    private List<BigInteger> generatedNumbers = new ArrayList<>(100);

    @Override
    public void run() {
        //an int is 4 bytes
        ByteBuffer countBuffer = ByteBuffer.allocate(4);

        try {
            int count = 100;
            countBuffer.putInt(count);
            countBuffer.flip();
            pipeSinkChannel.write(countBuffer);
            for(int i = 0;i<count;i++){
                //// These numbers can become arbitrarily large, and they grow
                //exponentially
                // so we have to use BigInteger as even long cannot hold the big ones
                //so no fixed size buffer will suffice.
                byte[] numberByteArray = generateFibonacci(i).toByteArray();
                int numberLength = numberByteArray.length;

                //contains the length of number followed by the number itself
                ByteBuffer buffer = ByteBuffer.allocate(4 + numberLength);
                //how many bytes are there in the number
                buffer.putInt(numberLength);
                // byte array from the number
                buffer.put(numberByteArray);
                buffer.flip();
                //System.out.println("\nproducer buffer: " + buffer);
                //System.out.println("producer buffer content: " + Arrays.toString(buffer.array()));
                pipeSinkChannel.write(buffer);
                //System.out.println("producer put " + number + " in channel");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                pipeSinkChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * this is not the best way to save existing fibonacci numbers, see CustomFibonacciProducerRunnable for a better approach
     * that saves more memory
     * @param n
     * @return
     */
    private BigInteger generateFibonacci(int n){
        if(n == 0 || n == 1){
            generatedNumbers.add(0, BigInteger.ONE);
            generatedNumbers.add(1, BigInteger.ONE);
            return BigInteger.ONE;
        }
        BigInteger numberBefore1 = generatedNumbers.get(n-1);
        if(numberBefore1 == null){
            numberBefore1 = generateFibonacci(n-1);
            generatedNumbers.add(n-1, numberBefore1);

        }
        BigInteger numberBefore2 = generatedNumbers.get(n-2);
        if(numberBefore2 == null){
            numberBefore2 = generateFibonacci(n-2);
            generatedNumbers.add(n-2, numberBefore2);

        }
        BigInteger currentNumber = numberBefore1.add(numberBefore2);
        generatedNumbers.add(n, currentNumber);
        return currentNumber;
    }

    public CustomFibonacciProducerRunnable(WritableByteChannel pipeSinkChannel) {
        this.pipeSinkChannel = pipeSinkChannel;
    }
}
