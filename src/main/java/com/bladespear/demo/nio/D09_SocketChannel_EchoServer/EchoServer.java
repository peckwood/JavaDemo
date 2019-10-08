package com.bladespear.demo.nio.D09_SocketChannel_EchoServer;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import static java.nio.channels.SelectionKey.OP_ACCEPT;
import static java.nio.channels.SelectionKey.OP_READ;

public class EchoServer {
    private static final String POISON_PILL = "POISON_PILL";

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost", 5454));
            //set it to non-blocking mode before registering it with a selector
            serverSocketChannel.configureBlocking(false);

            Selector selector = Selector.open();

            //server socket channel has only 1 operation: accept
            serverSocketChannel.register(selector, OP_ACCEPT);

            ByteBuffer buffer = ByteBuffer.allocate(64);

            //in a loop
            while (true) {
                selector.select();
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeySet.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isAcceptable()) {
                        // a connection was accepted by a ServerSocketChannel.
                        System.out.println("acceptable");
                        register(selector, serverSocketChannel);
                    } else if (key.isReadable()) {
                        // a channel is ready for reading
                        System.out.println("readable");
                        answerWithEcho(key, buffer);
                    }
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void register(Selector selector, ServerSocketChannel serverSocketChannel) throws IOException {
        SocketChannel client = serverSocketChannel.accept();
        client.configureBlocking(false);
        client.register(selector, OP_READ);
    }

    public static void answerWithEcho(SelectionKey key, ByteBuffer buffer) throws IOException {
        SocketChannel client = (SocketChannel) key.channel();
        client.read(buffer);
        String msg = new String(buffer.array());
        if(msg.trim().equals(POISON_PILL)){
            client.close();
            buffer = null;
            System.out.println("Not accepting client messages anymore");
            System.exit(0);
        }
        //When we desire to write to a buffer from which we have been reading, we must call the flip() method.
        buffer.flip();
        client.write(buffer);
        buffer.clear();
    }
    public static Process start() throws IOException {
        String javaHome = System.getProperty("java.home");
        String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
        String classpath = System.getProperty("java.class.path");
        String className = EchoServer.class.getCanonicalName();

        ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp", classpath, className);

        return builder.start();
    }

}
