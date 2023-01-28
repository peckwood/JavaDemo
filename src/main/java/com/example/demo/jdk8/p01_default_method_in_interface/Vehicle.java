package com.example.demo.jdk8.p01_default_method_in_interface;

public interface Vehicle {
    String getBrand();

    String speedUp();

    String slowDown();

    default String turnLightOn() {
        return "亮灯";
    }

    default String turnLightOff() {
        return "灭灯";
    }
}
