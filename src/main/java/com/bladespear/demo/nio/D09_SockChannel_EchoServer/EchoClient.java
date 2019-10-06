package com.bladespear.demo.nio.D09_SockChannel_EchoServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class EchoClient {
    private static SocketChannel client;
    private static ByteBuffer buffer;
    private static EchoClient instance;

    public static void main(String[] args) {
//        try {
//            SocketChannel socketChannel = SocketChannel.open();
//            socketChannel.bind(new InetSocketAddress("localhost", 5454));
//            Selector selector = Selector.open();
//            int intersetSet = OP_ACCEPT | OP_WRITE | OP_READ | OP_WRITE;
//            SelectionKey key = socketChannel.register(selector, intersetSet);
//
//            selector.select();
//            if (key.isAcceptable()) {
//                // a connection was accepted by a ServerSocketChannel.
//                System.out.println("acceptable");
//
//            } else if (key.isConnectable()) {
//                // a connection was established with a remote server.
//                System.out.println("connectable");
//            } else if (key.isReadable()) {
//                // a channel is ready for reading
//                System.out.println("readable");
//            } else if (key.isWritable()) {
//                // a channel is ready for writing
//                System.out.println("writable");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    public static EchoClient start() {
        if (instance == null) {
            instance = new EchoClient();
        }
        return instance;
    }

    public static void stop() throws IOException {
        client.close();
        buffer = null;
    }

    public EchoClient() {
        try {
            client = SocketChannel.open(new InetSocketAddress("localhost", 5454));
            buffer = ByteBuffer.allocate(256);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String sendMessage(String msg) {
        buffer = ByteBuffer.wrap(msg.getBytes());
        String response = null;
        try {
            client.write(buffer);
            buffer.clear();
            client.read(buffer);
            response = new String(buffer.array()).trim();
            System.out.println("response: " + response);
            buffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }


}
