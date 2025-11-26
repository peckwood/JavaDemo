package com.example.demo.annotation.serialize_with_custom_annotation.exception;

public class JsonSerializationException extends RuntimeException{
    public JsonSerializationException(String message){
        super(message);
    }
}
