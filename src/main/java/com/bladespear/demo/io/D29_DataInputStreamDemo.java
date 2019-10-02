package com.bladespear.demo.io;

import java.io.*;

public class D29_DataInputStreamDemo {
    static String filePath = "io/out.data";

    public static void main(String[] args) {

        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);
             DataOutputStream output = new DataOutputStream(fileOutputStream)) {
            String string = "abc";
            int int1 = 100;
            float float1 = 200.5f;
            char char1 = 'd';
            output.writeUTF(string);
            output.writeInt(int1);
            output.writeFloat(float1);
            output.writeChar(char1);
            output.writeChars(string);
            output.writeUTF(System.lineSeparator());
            output.writeBoolean(false);

        } catch (IOException e) {
            e.printStackTrace();
        }

        readData();
    }

    public static void readData() {
        try (DataInputStream input = new DataInputStream(new FileInputStream(filePath))) {

            String string = input.readUTF();
            System.out.println(string);

            int int1 = input.readInt();
            System.out.println(int1);

            float float1 = input.readFloat();
            System.out.println(float1);

            char char1 = input.readChar();
            System.out.println(char1);

            for(int i=0;i<3;i++){
                char char2 = input.readChar();
                System.out.println(char2);
            }

            String string2 = input.readUTF();
            System.out.println("line seperator: " + string2);

            boolean boolean1 = input.readBoolean();
            System.out.println(boolean1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
