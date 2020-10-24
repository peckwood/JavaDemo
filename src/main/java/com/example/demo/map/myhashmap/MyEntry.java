package com.example.demo.map.myhashmap;

public class MyEntry<K, V>{
    private final K key;
    private V value;
    private MyEntry<K, V> next;

    public MyEntry(K key, V value, MyEntry<K, V> next){
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public MyEntry<K, V> getNext(){
        return next;
    }

    public void setNext(MyEntry<K, V> next){
        this.next = next;
    }

    public K getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }

    public void setValue(V value){
        this.value = value;
    }
}
