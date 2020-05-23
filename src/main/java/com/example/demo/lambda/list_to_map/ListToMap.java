package com.example.demo.lambda.list_to_map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//convert list to map using lambda
public class ListToMap{
    public static void main(String[] args){
        List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(3, "digitalocean.com", 120000));
        list.add(new Hosting(4, "aws.amazon.com", 200000));
        list.add(new Hosting(5, "mkyong.com", 1));

        //approach 1
        Map<Integer, String> map1 = list.stream().collect(Collectors.toMap(item -> item.getId(), item -> item.getName()));
        System.out.println("map1: " + map1);

        //approach 2
        Map<Integer, String> map2 = list.stream().collect(Collectors.toMap(Hosting::getId, Hosting::getName));
        System.out.println("map2: " + map2);


    }
}
