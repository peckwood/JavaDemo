package com.example.demo.json.jackson_demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TypeReferenceDemo {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static void main(String[] args) throws IOException {
        MyEntity e1 = new MyEntity(1, "name1");
        MyEntity e2 = new MyEntity(2, "name2");
        List<MyEntity> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);

        String json = objectMapper.writeValueAsString(list);
        System.out.println("json: " + json);

        List<MyEntity> listWithTypeReference = objectMapper.readValue(json, new TypeReference<List<MyEntity>>(){});
        System.out.println("listWithTypeReference: " + listWithTypeReference);

//        报错
//        MyEntity myEntity = objectMapper.readValue(json, MyEntity.class);
//        System.out.println("myEntity: " + myEntity);
        List<MyEntity> listWithoutTypeReference = objectMapper.readValue(json, List.class);
        System.out.println("listWithoutTypeReference(虽然指定要MyEntitty, 实际上元素是LinkedHashMap): " + listWithoutTypeReference);
    }
}
