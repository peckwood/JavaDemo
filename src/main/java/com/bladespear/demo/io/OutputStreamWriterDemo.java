package com.bladespear.demo.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * OutputStreamWriter converts OutputStream to Writer
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) {
        String story = "故事 Eternal love\n" +
                "\n" +
                "One day at work, Amanda received a beautiful flower bouquet. In it, she counted 11 flowers and found a short note in it. It was written in beautiful lettering and said:\n" +
                "\n" +
                "“My love for you will last until the day the last flower in this bouquet dies.”\n" +
                "\n" +
                "The note was from her husband who had gone on a business trip. Unsure as to what to make of the message, she went home in the evening and soaked the flowers with water. One day after another, the flowers became a little less beautiful until they all died. All but one flower. This was the day when she realized that there was one artificial flower in the bouquet that would last forever.";
        //you can set append or not
        boolean append = false;
        //Charset.forName("GB2312")
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                new FileOutputStream("D:/eternal_love.txt", append), StandardCharsets.UTF_8)){
            char[] charArray = story.toCharArray();
            outputStreamWriter.write(charArray, 0, charArray.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
