package com.example.demo.annotation.serialize_with_custom_annotation;

import com.example.demo.annotation.serialize_with_custom_annotation.annotation.Init;
import com.example.demo.annotation.serialize_with_custom_annotation.annotation.JsonElement;
import com.example.demo.annotation.serialize_with_custom_annotation.annotation.JsonSerializable;
import com.example.demo.annotation.serialize_with_custom_annotation.exception.JsonSerializationException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// related note: obsidian://open?vault=obsidian-prof&file=learn-notes%2Fjava%2Fjava-annotation%2Fwrite-custom-annotation
// tutorial: https://www.baeldung.com/java-custom-annotation
public class ObjectToJsonConverter{
    public static void main(String[] args) throws Exception{
        ObjectToJsonConverter converter = new ObjectToJsonConverter();
        Person person = new Person();
        person.setFirstName("john");
        person.setLastName("doe");
        person.setAddress("123 Main St");
        person.setAge("32");
        if(converter.checkIfSerializable(person)){
            converter.initializeObject(person);
            System.out.println(converter.getJsonString(person));
        }
    }
    private boolean checkIfSerializable(Object object) throws InvocationTargetException, IllegalAccessException{
        if(Objects.isNull(object)){
            throw new JsonSerializationException("Object is null");
        }else{
            Class<?> clazz = object.getClass();
            return clazz.isAnnotationPresent(JsonSerializable.class);
        }
    }

    private void initializeObject(Object object) throws InvocationTargetException, IllegalAccessException{
        Class<?> clazz = object.getClass();
        //getMethods只能看到public method
        //getDeclaredMethods 能看到private method
        for (Method method : clazz.getDeclaredMethods()){
            boolean annotationPresent = method.isAnnotationPresent(Init.class);
            if(annotationPresent){
                method.setAccessible(true);
                method.invoke(object);
            }
        }
    }

    private String getJsonString(Object object) throws Exception {
        Class<?> clazz = object.getClass();
        Map<String, String> jsonElementsMap = new HashMap<>();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonElement.class)) {
                jsonElementsMap.put(getKey(field), (String) field.get(object));
            }
        }

        //用toString代替了serialize
        return jsonElementsMap.toString();
    }

    private String getKey(Field field) {
        JsonElement jsonElement = field.getAnnotation(JsonElement.class);
        String key = jsonElement.key();

        // If key is specified in annotation, use it; otherwise use field name
        if (!key.isEmpty()) {
            return key;
        } else {
            return field.getName();
        }
    }
}
