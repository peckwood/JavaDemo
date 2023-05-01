package com.example.demo.openai;

import java.io.Serializable;

public class ResponseData implements Serializable {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
