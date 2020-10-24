package com.example.demo.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class D05_Channel_to_Channel {
    public static void main(String[] args) {
        //must be one of "r", "rw", "rws", or "rwd"
        try(RandomAccessFile fromFile = new RandomAccessFile("nio/D05_from_file.txt", "r");
            RandomAccessFile toFile = new RandomAccessFile("nio/D05_to_file.txt", "rw");
            FileChannel fromChannel = fromFile.getChannel();
            FileChannel toChannel = toFile.getChannel();) {
            fromChannel.transferTo(0L, fromChannel.size(), toChannel);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
