package com.bladespear.demo.nio.D12_DatagramChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * based on https://www.tutorialspoint.com/java_nio/java_nio_datagram_channel.htm
 */
public class DatagramChannelServer {
    public static void main(String[] args) throws IOException {
        DatagramChannel server = DatagramChannel.open();
        SocketAddress socketAddress = new InetSocketAddress("localhost", 8989);
        server.bind(socketAddress);

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        SocketAddress remoteAddr = server.receive(buffer);
        buffer.flip();
        int limit = buffer.limit();
        byte[] bytes = new byte[limit];
        buffer.get(bytes, 0, limit);
        String msg = new String(bytes);
        System.out.println("remote address " + remoteAddr + " sent " + msg);
        //echo the msg
        buffer.flip();
        server.send(buffer, remoteAddr);

        server.close();
    }
}
