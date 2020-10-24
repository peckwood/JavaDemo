package com.example.demo.nio.D09_SocketChannel_EchoServer;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * based on https://www.baeldung.com/java-nio-selector
 */
public class EchoTest {
    static Process server;
    static EchoClient client;

    public static void main(String[] args) throws IOException {
        setup();
        givenServerClient_whenServerEchosMessage_thenCorrect();
        teardown();
    }

    public static void setup() throws IOException {
        server = EchoServer.start();
        client = EchoClient.start();
    }

    public static void givenServerClient_whenServerEchosMessage_thenCorrect() {
        String resp1 = client.sendMessage("hello");
        String resp2 = client.sendMessage("world");
        assertEquals("hello", resp1);
        assertEquals("world", resp2);
    }

    public static void teardown() throws IOException {
        server.destroy();
        EchoClient.stop();
    }

}
