package com.bladespear.demo.io;

import java.io.*;
import java.time.Instant;

public class BufferedOutputStreamDemo {
    public static void main(String[] args) {
        int bufferSize = 4 * 1024;
        String sourceImpagePath = "parrot.jpg";
        String absoluteImagePath = "D:\\workspace\\java_project\\org_json_demo\\src\\main\\resources\\parrot.jpg";
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(Instant.now().getNano());
        try (InputStream inputStream = classLoader.getResourceAsStream(sourceImpagePath);
             //InputStream inputStream = new FileInputStream(absoluteImagePath);
             BufferedInputStream input = new BufferedInputStream(inputStream, bufferSize);
             BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("D://parrot.jpg"))
        ) {


            byte[] buffer = new byte[bufferSize];
            int bytesRead = -1;
            do {
                bytesRead = input.read(buffer, 0, bufferSize);
                //System.out.println("read " + bytesRead + " bytes");
                if (bytesRead != -1) {
                    output.write(buffer, 0, bytesRead);
                }
            } while (bytesRead != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //You can achieve similar result with FileInputStream
        System.out.println(Instant.now().getNano());
        try (InputStream inputStream1 = classLoader.getResourceAsStream(sourceImpagePath);
             //InputStream inputStream1 = new FileInputStream(absoluteImagePath);
             BufferedOutputStream output1 = new BufferedOutputStream(new FileOutputStream("D://parrot1.jpg"))) {

            byte[] buffer1 = new byte[bufferSize];
            int bytesRead1 = -1;
            do {
                bytesRead1 = inputStream1.read(buffer1, 0, bufferSize);
                //System.out.println("read " + bytesRead1 + " bytes");
                if (bytesRead1 != -1) {
                    output1.write(buffer1, 0, bytesRead1);
                }
            } while (bytesRead1 != -1);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Instant.now().getNano());

    }
}
