package com.example.demo.jdk8.p01_default_method_in_interface;

public class Car implements Vehicle{
    private final String brand;

    public Car(String brand) {
        this.brand = brand;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String speedUp() {
        return "正在加速";
    }

    @Override
    public String slowDown() {
        return "正在减速";
    }

    @Override
    public String turnLightOff() {
        return "Car灭灯";
    }
}
