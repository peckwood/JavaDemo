package com.example.demo.realworldexample.aggregateprovince;

import java.util.*;
import java.util.stream.*;

public class ProvinceAggregateExampleB {
    static class City {
        String provinceId;
        String cityId;
        long male;
        long female;
        City(String p, String c, long m, long f) { provinceId = p; cityId = c; male = m; female = f; }
        public String getProvinceId(){return provinceId;}
        public long getMale(){return male;}
        public long getFemale(){return female;}
        public void setMale(long m){male = m;}
        public void setFemale(long f){female = f;}
        @Override public String toString(){return provinceId+": m="+male+", f="+female;}    }

    public static void main(String[] args) {
        List<City> cities = Arrays.asList(
            new City("shanxi","taiyuan",100,120),
            new City("shanxi","datong",150,130),
            new City("shanxi","linfen",150,130),
            new City("shandong","qingdao",150,130),
            new City("shandong","heze",200,210),
            new City("shandong","longkou",200,210)
        );

        Map<String, City> grouped = cities.stream()
            .collect(Collectors.groupingBy(
                City::getProvinceId,
                Collector.of(
                    () -> new City(null, null, 0, 0),                       // supplier
                    (City acc, City c) -> {                                   // accumulator
                        if (acc.getProvinceId() == null) acc.provinceId = c.getProvinceId();
                        acc.setMale(acc.getMale() + c.getMale());
                        acc.setFemale(acc.getFemale() + c.getFemale());
                    },
                    (City left, City right) -> {                              // combiner
                        left.setMale(left.getMale() + right.getMale());
                        left.setFemale(left.getFemale() + right.getFemale());
                        return left;
                    }
                )
            ));

        grouped.values().forEach(System.out::println);
    }
}