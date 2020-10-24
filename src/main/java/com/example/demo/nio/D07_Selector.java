package com.example.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class D07_Selector {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9000));
        SocketChannel clientSocketChannel = serverSocketChannel.accept();
        SocketChannel channel = SocketChannel.open();
        channel.connect(new InetSocketAddress("127.0.0.1", 80));
        //channel must be in non-blocking mode to be used with a selector
        channel.configureBlocking(false);
        //set of operations you are interested in "selecting"
        int interestSet = SelectionKey.OP_READ;
        int interestSet1 = SelectionKey.OP_READ | SelectionKey.OP_CONNECT;
        SelectionKey selectionKey = channel.register(selector, interestSet);

        //blocks untils at least one channel is ready for operation
        selector.select();

        //will return all selected keys registered with this selector
        //selector can be registered by multiple channels, each registration is represented by a selectionKey
        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        Iterator<SelectionKey> iterator = selectionKeys.iterator();
        while(iterator.hasNext()){
            SelectionKey key = iterator.next();
            if(key.isAcceptable()) {
                // a connection was accepted by a ServerSocketChannel.

            } else if (key.isConnectable()) {
                // a connection was established with a remote server.

            } else if (key.isReadable()) {
                // a channel is ready for reading

            } else if (key.isWritable()) {
                // a channel is ready for writing
            }
            //when you are done with the channel, you need to remove key from the set
            iterator.remove();
        }

        selector.close();


    }

    /**
     * find out if a operation is in the interest set
     * @param selectionKey
     */
    void getInterestsSetBySelectionKey(SelectionKey selectionKey){
        int interestSet = selectionKey.interestOps();
//        boolean interestedInRead = interestSet & SelectionKey.OP_READ;
//        boolean interestedInAccept = interestSet & SelectionKey.OP_ACCEPT;
//        boolean interestedInConnect = interestSet & SelectionKey.OP_CONNECT;
//        boolean interestedInWhite = interestSet & SelectionKey.OP_WRITE;

    }

    /**
     * get if the key's channel is ready for a certain operation
     * @param selectionKey
     */
    void getReadySetBySelectionKey(SelectionKey selectionKey){
        int readySet = selectionKey.readyOps();
        selectionKey.isReadable();
        selectionKey.isAcceptable();
        selectionKey.isConnectable();
        selectionKey.isWritable();
    }

    void getChannelAndSelectorFromSelectionKey(SelectionKey selectionKey){
        selectionKey.channel();
        selectionKey.selector();
        //attach object
        Object object = new Object();
        selectionKey.attach(object);

    }
}
