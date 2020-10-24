package com.example.demo.nio.D09_SocketChannel_FileSender;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Run FileReceiver and then FileSender
 * based on https://examples.javacodegeeks.com/core-java/nio/java-nio-socketchannel-example/
 */
public class FileReceiver {

    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", 5455);
        String outPathString = "nio/D09_SocketChannel_FileSender_out_parrot.jpg";
        Path outPath = Paths.get(outPathString);

        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()
                .bind(inetSocketAddress);
             SocketChannel socketChannel = serverSocketChannel.accept();
             FileChannel fileChannel = FileChannel.open(outPath, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE)) {

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int bytesRead = socketChannel.read(buffer);
            while (true) {
                if (bytesRead != -1) {
                    //When we desire to write to a buffer from which we have been reading, we must call the flip() method.
                    buffer.flip();
                    fileChannel.write(buffer);
                    //if you forget 'bytesRead =', it will keep running and the out file gets larger and larger
                    buffer.clear();
                    bytesRead = socketChannel.read(buffer);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
