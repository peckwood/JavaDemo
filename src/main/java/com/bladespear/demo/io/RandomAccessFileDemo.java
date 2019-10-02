package com.bladespear.demo.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
    public static void main(String[] args) {
        String path = "input.txt";
        File inputFile = new File("D:\\workspace\\java_project\\org_json_demo\\src\\main\\resources\\input.txt");
        try(RandomAccessFile file = new RandomAccessFile(inputFile, "rw")) {
            file.seek(200);
            byte[] buffer = new byte[257];
            int bytesRead = file.read(buffer, 0, buffer.length);
            String content = new String(buffer, 0, bytesRead);
            System.out.println(content);
            content = content.concat("他倒是怪务实");
            file.seek(200);
            file.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
