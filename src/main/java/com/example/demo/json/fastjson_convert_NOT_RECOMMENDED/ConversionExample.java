package com.example.demo.json.fastjson_convert_NOT_RECOMMENDED;

import com.alibaba.fastjson.JSONObject;

/**
 * json object, java object, json string 互转
 */
public class ConversionExample {

    static DomainObject javaObj = new DomainObject("name1");

    public static void main(String[] args) {

        JSONObject jsonObj = getJSONObject(javaObj);
        System.out.println("1. java object > json object: " + jsonObj);

        String jsonString = getJsonString(javaObj);
        System.out.println("2. java object > json string: " + jsonString);

        JSONObject jsonObject = JSONObject.parseObject(getJsonString(javaObj));
        System.out.println("3.1 json string > jsonObject: " + jsonObject);

        JSONObject jsonObject3 = (JSONObject) JSONObject.parse(getJsonString(javaObj));
        System.out.println("3.2 json string > jsonObject: " + jsonObject3);

        DomainObject resultJavaObj = JSONObject.parseObject(getJsonString(javaObj), DomainObject.class);
        System.out.println("4. json string > java object: " + resultJavaObj);

        DomainObject javaObject = JSONObject.toJavaObject(getJSONObject(javaObj), DomainObject.class);
        System.out.println("5. json obj > java object: " + javaObject);
        DomainObject javaObject2 = getJSONObject(javaObj).toJavaObject(DomainObject.class);
        System.out.println("5.2 json obj > java object: " + javaObject2);

        String jsonString2 = JSONObject.toJSONString(getJSONObject(javaObj));
        System.out.println("6. json object to json string: " + jsonString2);


    }

    private static JSONObject getJSONObject(Object javaObj){
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(javaObj);
        return jsonObject;
    }

    private static String getJsonString(Object javaObj){
        String jsonString = JSONObject.toJSONString(javaObj);
        return jsonString;
    }

//
private static Object ttt(String jsonString) {
    Object obj = JSONObject.parse(jsonString);
    return obj;
}
}
