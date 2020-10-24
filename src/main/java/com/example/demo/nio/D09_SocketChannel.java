package com.example.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class D09_SocketChannel {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(9000));
            SocketChannel clientSocketChannel = serverSocketChannel.accept();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
