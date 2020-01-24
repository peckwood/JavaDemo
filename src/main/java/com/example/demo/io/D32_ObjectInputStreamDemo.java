package com.example.demo.io;

import java.io.*;

public class D32_ObjectInputStreamDemo {
    public static void main(String[] args) {
        String filePath = "io/generated_object.data";
        try(FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ObjectOutputStream output = new ObjectOutputStream(fileOutputStream)) {
            //class must be Serializable
            D32_Person person = new D32_Person("Raiden", 27);
            output.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream input = new ObjectInputStream(fileInputStream);
            D32_Person person = (D32_Person) input.readObject();
            System.out.println(person);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
