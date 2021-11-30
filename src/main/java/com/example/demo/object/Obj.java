package com.example.demo.object;

public class Obj {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String toString() {
        return "Obj{" +
                "name='" + name + '\'' +
                '}';
    }
}
