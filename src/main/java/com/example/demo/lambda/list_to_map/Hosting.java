package com.example.demo.lambda.list_to_map;

public class Hosting{
    private int id;
    private String name;
    private long websites;

    public Hosting(int id, String name, long websites){
        this.id = id;
        this.name = name;
        this.websites = websites;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public long getWebsites(){
        return websites;
    }
}
