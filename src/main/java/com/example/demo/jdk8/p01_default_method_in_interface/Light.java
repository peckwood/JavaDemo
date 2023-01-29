package com.example.demo.jdk8.p01_default_method_in_interface;

public interface Light {
    default String turnLightOn() {
        return "灯亮了";
    }

    default String turnLightOff() {
        return "灯灭了";
    }
}
