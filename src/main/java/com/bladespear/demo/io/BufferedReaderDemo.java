package com.bladespear.demo.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class BufferedReaderDemo {
    public static void main(String[] args) {
        String textFilePath = "input.txt";
        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(textFilePath);
             //设置编码
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(inputStreamReader)) {

            String line = reader.readLine();
            System.out.println(line);
            while(line != null){
                line = reader.readLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
