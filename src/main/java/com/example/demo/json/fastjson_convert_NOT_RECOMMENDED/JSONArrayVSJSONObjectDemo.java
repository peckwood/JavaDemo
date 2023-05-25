package com.example.demo.json.fastjson_convert_NOT_RECOMMENDED;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONArrayVSJSONObjectDemo {
    /*
    结论
    toJSONString 把对象转为JSONString, 和JSONObject还是JSONArray调无关
    parseObject, 把JSONString转为对象, 和JSONObject还是JSONArray调无关

    parseArray同理
     */
    public static void main(String[] args) {
        List<DomainObject> objectList = new ArrayList<>();
        DomainObject obj1 = new DomainObject("name1");
        DomainObject obj2 = new DomainObject("name2");
        objectList.add(obj1);
        objectList.add(obj2);
        JSONArray.parseObject(null);

        //convert java list to json
        String listJsonString = JSONArray.toJSONString(objectList);

        //convert java list to json (result is the same as JSONArray)
        String listJsonString2 = JSONObject.toJSONString(objectList);

        System.out.println("listJsonString: " + listJsonString);

        System.out.println("listJsonString2(same as JSONArray): " + listJsonString2);

        System.out.println(JSONArray.parseObject(getObjectJsonString(), DomainObject.class));

        //会报错
        //JSONArray.parseObject(listJsonString, DomainObject.class);

        List<DomainObject> list2 = JSONArray.parseArray(listJsonString, DomainObject.class);

        List<DomainObject> list3 = JSONObject.parseArray(listJsonString, DomainObject.class);

        System.out.println("list2: " + list2);
        System.out.println("list3: " + list3);
    }

    private static String getObjectJsonString(){
        DomainObject obj1 = new DomainObject("name1");
        String jsonString = JSONObject.toJSONString(obj1);
        System.out.println("jsonString: " + jsonString);
        return jsonString;
    }
}
