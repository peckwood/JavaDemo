package com.bladespear.demo.nio.D09_SocketChannel_FileSender_Selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import java.util.Set;

/**
 * not recommended, the code is not working properly
 * the receiver keeps selecting
 */
public class FileReceiver {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", 5456);
        serverSocketChannel.bind(inetSocketAddress);
        //need to set to non-blocking mode before registering, or it throws IllegalBlockingModeException
        serverSocketChannel.configureBlocking(false);

        Selector selector = Selector.open();

        //server socket channel has only 1 operation: accept
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        ByteBuffer buffer = ByteBuffer.allocate(2048);

        //in a loop
        while (true){
            selector.select();
            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeySet.iterator();
            while(iterator.hasNext()){
                SelectionKey key = iterator.next();
                if(key.isAcceptable()){
                    System.out.println("acceptable");
                    SocketChannel client = serverSocketChannel.accept();
                    //need to set to non-blocking mode before registering, or it throws IllegalBlockingModeException
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ);
                }else if(key.isReadable()){
                    System.out.println("readable");
                    readFileContent(key, buffer);
                }
                //do not forget to remove the key, or you will get inside key.isAcceptable() twice
                iterator.remove();
            }

        }
    }

    public static void readFileContent(SelectionKey key, ByteBuffer buffer) throws IOException {

        SocketChannel socketChannel = (SocketChannel) key.channel();
        FileChannel fileChannel;
        if(key.attachment()==null){
            String outPathString = "nio/D09_SocketChannel_FileSender_out_parrot.jpg";
            Path outPath = Paths.get(outPathString);
            fileChannel = FileChannel.open(outPath, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
            key.attach(fileChannel);
        }else{
            fileChannel = (FileChannel) key.attachment();
        }
        SocketChannel client = (SocketChannel) key.channel();

        //approach 1
        //only works if FileSender send with transferTo (approache 1)
//        fileChannel.transferFrom(client, 0, 180000);

        //approach 2
        int bytesRead = socketChannel.read(buffer);
        System.out.println("bytesRead1: " + bytesRead);
        if(bytesRead == -1){
            fileChannel.close();
            client.close();
        }
        while (true){
            if(bytesRead != -1){
                //When we desire to write to a buffer from which we have been reading, we must call the flip() method.
                buffer.flip();
                while(buffer.hasRemaining()) {
                    fileChannel.write(buffer);
                }
                //if you forget 'bytesRead =', it will keep running and the out file gets larger and larger
                buffer.clear();
                bytesRead = socketChannel.read(buffer);
                System.out.println("bytesRead2: " + bytesRead);
            }else{
                break;
            }
        }
    }

    public static void startChannel() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", 5456);
        serverSocketChannel = serverSocketChannel.bind(inetSocketAddress);
        //need to set to non-blocking mode before registering, or it throws IllegalBlockingModeException
        serverSocketChannel.configureBlocking(false);

        Selector selector = Selector.open();

        //server socket channel has only 1 operation: accept
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        ByteBuffer buffer = ByteBuffer.allocate(2048);

        //in a loop
        while (true){
            System.out.println("select");
            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeySet.iterator();
            while(iterator.hasNext()){
                SelectionKey key = iterator.next();
                if(key.isAcceptable()){
                    SocketChannel client = serverSocketChannel.accept();
                    //need to set to non-blocking mode before registering, or it throws IllegalBlockingModeException
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ);
                }else if(key.isReadable()){
                    readFileContent(key, buffer);
                }
                //do not forget to remove the key, or you will get inside key.isAcceptable() twice
                iterator.remove();
            }

        }

    }
}
