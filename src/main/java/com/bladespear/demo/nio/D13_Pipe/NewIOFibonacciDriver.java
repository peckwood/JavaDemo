package com.bladespear.demo.nio.D13_Pipe;

import java.io.IOException;
import java.nio.channels.*;

/**
 * copied from https://flylib.com/books/en/1.134.1/pipe_channels.html
 */
public class NewIOFibonacciDriver {
    public static void main (String[] args) throws IOException {
        Pipe pipe = Pipe.open( );
        WritableByteChannel out = pipe.sink( );
        ReadableByteChannel in = pipe.source( );
        FibonacciProducer producer = new FibonacciProducer(out, 200);
        FibonacciConsumer consumer = new FibonacciConsumer(in);
        producer.start( );
        consumer.start( );
    }
}