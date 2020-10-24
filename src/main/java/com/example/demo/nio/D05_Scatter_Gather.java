package com.example.demo.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class D05_Scatter_Gather {
    public static void main(String[] args) {
        try (
                RandomAccessFile file = new RandomAccessFile("io/D05_scatter_gather.txt", "rw");
        ) {
            ByteBuffer headerBuffer = ByteBuffer.allocate(128);
            ByteBuffer bodyBuffer = ByteBuffer.allocate(1024);
            FileChannel channel = file.getChannel();
            ByteBuffer[] buffers = {headerBuffer, bodyBuffer};
            channel.read(buffers);

            ByteBuffer header = ByteBuffer.allocate(128);
            ByteBuffer body = ByteBuffer.allocate(1024);
            //write data into buffers
            ByteBuffer[] bufferArray = {header, body};
            channel.write(bufferArray);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
