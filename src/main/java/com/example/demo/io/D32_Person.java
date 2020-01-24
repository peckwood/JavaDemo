package com.example.demo.io;

import java.io.Serializable;

public class D32_Person implements Serializable {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "D32_Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public D32_Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
