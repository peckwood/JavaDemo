package com.bladespear.demo.nio.D09_SocketChannel_FileSender_Selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

/**
 * not recommended, the code is not working properly
 * the receiver keeps selecting
 */
public class FileReceiver {

    public static void main(String[] args) throws IOException {
        startChannel();
    }

    public static void readFileContent(SelectionKey key, ByteBuffer buffer) throws IOException {

        SocketChannel socketChannel = (SocketChannel) key.channel();
        FileChannel fileChannel;
        if(key.attachment()==null){
            String outPathString = "nio/D09_SocketChannel_FileSender_out_parrot.jpg";
            Path outPath = Paths.get(outPathString);
            fileChannel = FileChannel.open(outPath, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
            key.attach(fileChannel);
        }else{
            fileChannel = (FileChannel) key.attachment();
        }

        //fileChannel.transferFrom(client, 0, 1);
        int bytesRead = socketChannel.read(buffer);
        while (true){
            if(bytesRead != -1){
                //When we desire to write to a buffer from which we have been reading, we must call the flip() method.
                buffer.flip();
                fileChannel.write(buffer);
                //if you forget 'bytesRead =', it will keep running and the out file gets larger and larger
                buffer.clear();
                bytesRead = socketChannel.read(buffer);
            }else{
                break;
            }
        }
    }

    public static void startChannel() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", 5455);
        serverSocketChannel = serverSocketChannel.bind(inetSocketAddress);
        //need to set to non-blocking mode before registering, or it throws IllegalBlockingModeException
        serverSocketChannel.configureBlocking(false);

        Selector selector = Selector.open();

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            selector.select();
            System.out.println("select");
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            ByteBuffer buffer = ByteBuffer.allocate(2048);
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
