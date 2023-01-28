package com.example.demo.jdk8.p01_foreach;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ForEachDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(50);
        for (int i = 1; i<= 50; i++){
            list.add(i);
        }

        System.out.println("使用增强for遍历: ");
        for(Integer i2 : list){
            System.out.print(i2 + " ");
        }
        System.out.println();

        System.out.println("用iterator遍历: ");
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        System.out.println("用Iterable接口的forEach方法");
        list.forEach(integer -> System.out.print(integer + " "));
//        list.forEach(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.print(integer + " ");
//                System.out.print(integer + " ");
//            }
//        });
        System.out.println();
    }
}
