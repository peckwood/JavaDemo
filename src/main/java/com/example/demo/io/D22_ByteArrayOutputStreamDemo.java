package com.example.demo.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * ByteArrayInputStream's can be handy if your data is stored in an array,
 * but you have a component that can only process it as an InputStream.
 * The ByteArrayInputStream can thus wrap the byte array, and turn it into a stream.
 */
public class D22_ByteArrayOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        String data1 = "你好 ByteArrayOutputStream!";
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        output.write(data1.getBytes(StandardCharsets.UTF_8));

        //this needs to be after output.write()
        ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
        int bufferLength = input.available();

        //approach 1
        byte[] buffer = new byte[bufferLength];
        int bytesRead = input.read(buffer, 0, bufferLength);
        System.out.println("received: " + new String(buffer, 0, bytesRead, StandardCharsets.UTF_8));
        System.out.println(bytesRead + " bytes were read");


        //approach 2
/*        byte[] buffer = new byte[bufferLength];
        input.read(buffer);
        System.out.println(new String(buffer));*/


        //approach 3: byte by byte, not working for asian characters as 1 character is 3 bytes
        //result: ä½ å¥½ ByteArrayOutputStream!
/*        int data = input.read();
        while (data != -1) {
            System.out.print((char) data);
            data = input.read();
        }*/

        //approach 3
//        int length = input.available();
//        byte[] buffer = new byte[length];
//        input.read(buffer);

    }
}
