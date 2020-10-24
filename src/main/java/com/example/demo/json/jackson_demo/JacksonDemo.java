//this should only work with org.codehaus.jackson
package com.example.demo.json.jackson_demo;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;

public class JacksonDemo {
    public static void main(String[] args) throws IOException {
        //jsonString to Long[]数组
        String longNumberJsonArrayString = "[1,2,3]";
        ObjectMapper mapper = new ObjectMapper();
        Long[] longNumbers = mapper.readValue(longNumberJsonArrayString, Long[].class);
        for(Long num : longNumbers){
            System.out.println(num);
        }

        //Object to JSON
        RetentionOrderPresubmitVerificationVo veri = new RetentionOrderPresubmitVerificationVo();
        veri.setRentOrderId("M1231212121212");
        veri.setTotalRetentionFee(1000000);
        veri.setTotalRentRefund(1000);
        Map<Long, Long> entityId_ToyId_Map = new HashMap<>(1);
        entityId_ToyId_Map.put(1L, 100L);
        veri.setEntityId_ToyId_Map(entityId_ToyId_Map);
        ObjectMapper objectMapper = new ObjectMapper();
        //convert object to json(object must have getter and maybe setter)
        String jsonString = objectMapper.writeValueAsString(veri);
        System.out.println("veri stringified: " + jsonString);

        //convert json to object
        RetentionOrderPresubmitVerificationVo veri1 = objectMapper.readValue(jsonString, RetentionOrderPresubmitVerificationVo.class);
        System.out.println("veri1: " + veri1);

        //List<Integer> to jsonString
        List<Integer> integerList = new ArrayList<>();
        integerList.add(4);
        integerList.add(3);
        integerList.add(5);
        String integerListJsonString = mapper.writeValueAsString(integerList);
        System.out.println("integerListJsonString: " + integerListJsonString);
        //jsonArray to List<Integer> or Integer[]
        List<Integer> a = mapper.readValue(integerListJsonString, ArrayList.class);
        Integer[] b = mapper.readValue(integerListJsonString, Integer[].class);
        System.out.println("a: " + a);
        System.out.println("b: " + Arrays.toString(b));
    }
}
