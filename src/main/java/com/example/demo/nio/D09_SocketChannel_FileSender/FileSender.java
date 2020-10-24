package com.example.demo.nio.D09_SocketChannel_FileSender;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Run FileReceiver and then FileSender
 * based on https://examples.javacodegeeks.com/core-java/nio/java-nio-socketchannel-example/
 */
public class FileSender {
    private static SocketChannel client;

    public static void main(String[] args) throws IOException {
        createChannel();
        sendFile();
    }

    public static void sendFile() throws IOException {
        String pathString = "io/parrot.jpg";
        Path path = Paths.get(pathString);

        FileChannel fileChannel = FileChannel.open(path);

        //approach 1
        fileChannel.transferTo(0, fileChannel.size(), client);

        //approach 2

//        ByteBuffer buffer = ByteBuffer.allocate(2048);
//        int bytesRead = fileChannel.read(buffer);
//        int i = 1;
//        while(true){
//            if(bytesRead != -1){
//                System.out.println(i++);
//                buffer.flip();
//                client.write(buffer);
//                buffer.clear();
//                bytesRead = fileChannel.read(buffer);
//            }else{
//                break;
//            }
//        }
        System.out.println("send file complete");
        fileChannel.close();
        client.close();
    }

    public static void createChannel() throws IOException {
        client = SocketChannel.open(new InetSocketAddress("localhost", 5455));
        client.configureBlocking(false);
    }
}
