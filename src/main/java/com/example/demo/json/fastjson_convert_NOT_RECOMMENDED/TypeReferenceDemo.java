package com.example.demo.json.fastjson_convert_NOT_RECOMMENDED;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.example.demo.json.jackson_demo.MyEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TypeReferenceDemo {
    public static void main(String[] args) throws IOException {
        MyEntity e1 = new MyEntity(1, "name1");
        MyEntity e2 = new MyEntity(2, "name2");
        List<MyEntity> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);

        String json = JSONObject.toJSONString(list);
        System.out.println("json: " + json);


        List<MyEntity> listWithTypeReference = JSONObject.parseObject(json, new TypeReference<List<MyEntity>>(){});
        System.out.println("listWithTypeReference: " + listWithTypeReference);

//        报错 syntax error, expect {, actual [, pos 0, fastjson-version 1.2.41
//        MyEntity myEntity = JSONObject.parseObject(json, MyEntity.class);
//        System.out.println("myEntity: " + myEntity);

        List<MyEntity> listWithoutTypeReference = JSONObject.parseObject(json, List.class);
        System.out.println("listWithoutTypeReference(虽然指定要MyEntitty, 实际上元素是JsonObject): " + listWithoutTypeReference);
    }
}
