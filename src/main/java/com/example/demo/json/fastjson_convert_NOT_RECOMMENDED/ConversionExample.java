package com.example.demo.json.fastjson_convert_NOT_RECOMMENDED;

import com.alibaba.fastjson.JSONObject;

/**
 * json object, java object, json string 互转
 */
public class ConversionExample {

    static DomainObject javaObj = new DomainObject("name1");

    public static void main(String[] args) {

        JSONObject jsonObj = javaObject2JsonObject(javaObj);
        System.out.println("1. java object > json object: " + jsonObj);

        String jsonString = javaObject2JsonString(javaObj);
        System.out.println("2. java object > json string: " + jsonString);

        JSONObject jsonObject = JSONObject.parseObject(javaObject2JsonString(javaObj));
        System.out.println("3. json string > jsonObject: " + jsonObject);

        DomainObject resultJavaObj = JSONObject.parseObject(javaObject2JsonString(javaObj), DomainObject.class);
        System.out.println("4. json string > java object: " + resultJavaObj);

        DomainObject javaObject = JSONObject.toJavaObject(javaObject2JsonObject(javaObj), DomainObject.class);
        System.out.println("5. json obj > java object: " + javaObject);

        String jsonString2 = JSONObject.toJSONString(javaObject2JsonObject(javaObj));
        System.out.println("6. json object to json string: " + jsonString2);

    }

    //java object to json object
    private static JSONObject javaObject2JsonObject(Object javaObj){
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(javaObj);
        return jsonObject;
    }

    // java object to json string
    private static String javaObject2JsonString(Object javaObj){
        String jsonString = JSONObject.toJSONString(javaObj);
        return jsonString;
    }
}
