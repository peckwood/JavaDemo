package com.bladespear.demo.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class D01_Channel {
    public static void main(String[] args) {

        try(RandomAccessFile file =  new RandomAccessFile("nio/D01_Channel_nio_data.txt", "rw");
            FileChannel inChannel = file.getChannel()) {
            //create buffer with capacity of 48 bytes
            ByteBuffer buffer = ByteBuffer.allocate(48);

            String beginingText = "Some custom Text at the start";
            //write into the buffer yourself
            buffer.put(beginingText.getBytes());
            int bytesRead = beginingText.length();
            //read into buffer
            //int bytesRead = inChannel.read(buffer);
            while(bytesRead != -1){
                System.out.print("\nRead: " + bytesRead + "|");
                //switches the buffer from writing mode to reading mode,
                //sets position back to 0, limit to where position just was
                buffer.flip();

                //this doesn't work for asian characters as there might always be a byte left behind
                while (buffer.hasRemaining()){
                    //read 1 byte at a time
                    System.out.print((char)buffer.get());
                }

                //make buffer ready for writing
                buffer.clear();
                bytesRead = inChannel.read(buffer);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
