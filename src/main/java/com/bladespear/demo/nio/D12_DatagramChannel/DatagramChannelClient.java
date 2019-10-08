package com.bladespear.demo.nio.D12_DatagramChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * based on https://www.tutorialspoint.com/java_nio/java_nio_datagram_channel.htm
 */
public class DatagramChannelClient {
    public static void main(String[] args) throws IOException {
        DatagramChannel client = DatagramChannel.open();

        client.bind(null);

        String msg = "Hello 中国";

        //approach 1
        ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());

        /*approach 2
        if you use 'put', remember to flip, to reset the position*/
//        byte[] bytes = msg.getBytes();
//        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
//        buffer.put(msg.getBytes());
//        buffer.flip();

        SocketAddress address = new InetSocketAddress("localhost", 8989);
        client.send(buffer, address);
        buffer.clear();

        //read the message
        client.receive(buffer);
        buffer.flip();
        int limit = buffer.limit();
        byte[] bytes = new byte[limit];
        buffer.get(bytes, 0, limit);
        String msg1 = new String(bytes);
        System.out.println(msg1);

        client.close();
    }
}
