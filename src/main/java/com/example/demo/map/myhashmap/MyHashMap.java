package com.example.demo.map.myhashmap;

import java.util.HashMap;

public class MyHashMap<K, V>{
    MyEntry<K, V>[] nodes;
    private int capacity;
    private int size;
    private static final int INITIAL_CAPACITY = 16;

    public MyHashMap(){
        this(INITIAL_CAPACITY);
    }

    public MyHashMap(int capacity){
        this.capacity = capacity;
        nodes = new MyEntry[capacity];
        size = 0;
    }

    public void put(K key, V value){
        int hash = hash(key);
        int index = hash % capacity;
        MyEntry<K, V> newEntry = new MyEntry<>(key, value, null);
        MyEntry<K, V> firstEntry = nodes[index];
        if(firstEntry == null){
            nodes[index] = newEntry;
            size++;
        }else{
            MyEntry<K, V> currentEntry = firstEntry;
            while(true){
                if(currentEntry.getKey().equals(key)){
                    currentEntry.setValue(value);
                    break;
                }else if(currentEntry.getNext() == null){
                    currentEntry.setNext(newEntry);
                    size++;
                    break;
                }else{
                    currentEntry = currentEntry.getNext();
                }
            }
        }
        size++;
        if(size > capacity * 0.75){
            System.out.println("need to resize");
        }
    }

    public V get(K key){
        int hash = hash(key);
        int index = hash % capacity;
        MyEntry<K, V> existingNode = nodes[index];
        while(existingNode != null && !key.equals(existingNode.getKey())){
            existingNode = existingNode.getNext();
        }
        MyEntry<K, V> matchingNode = existingNode;
        return matchingNode.getValue();
    }

    static final int hash(Object key){
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
