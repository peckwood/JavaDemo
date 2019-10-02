package com.bladespear.demo.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * InputStreamReader converts InputStream to Reader
 */
public class InputStreamReaderDemo {
    public static void main(String[] args) {
        String textFilePath = "input.txt";
        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(textFilePath);
             //设置编码
             InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {

            //获取编码
            System.out.println("encoding: " + reader.getEncoding());

            char[] buffer = new char[1024];
            int count = 1;
            int charsRead = reader.read(buffer, 0, buffer.length);
            if (charsRead != -1) {
                System.out.println("count: " + count++);
            }
            while (charsRead != -1) {
                System.out.println("count: " + count++);
                System.out.println(new String(buffer, 0, charsRead));
                charsRead = reader.read(buffer, 0, buffer.length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
