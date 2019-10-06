package com.bladespear.demo.nio.D08_FileChannel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelDemo {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("io/parrot.jpg");
             FileChannel inChannel = fileInputStream.getChannel();
             FileOutputStream fileOutputStream = new FileOutputStream("nio/parrot_copy1.jpg");
             FileChannel outChannel = fileOutputStream.getChannel()) {

            //copy a file with transferTo or transferFrom
            inChannel.transferTo(0, inChannel.size(), outChannel);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //也可以用buffer手动传输

        //另一种获取FileChannel的方法
        Path inPath = Paths.get("io/parrot.jpg");
        Path outpath = Paths.get("nio/parrot_copy2.jpg");

        try (FileChannel inChannel = FileChannel.open(inPath);
             //must have CREATE and WRITE or throws
             //or if the file does not exist, throws NoSuchFileException
             FileChannel outChannel = FileChannel.open(outpath, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

            ByteBuffer buffer = ByteBuffer.allocate(128);

            int bytesRead = -1;
            while (true) {
                bytesRead = inChannel.read(buffer);
                if (bytesRead != -1) {
                    //When we desire to write to a buffer from which we have been reading, we must call the flip() method.
                    buffer.flip();
                    outChannel.write(buffer);
                    //if you don't clear, bytesRead will always be 0
                    buffer.clear();
                } else {
                    break;
                }
            }
            outChannel.force(false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
