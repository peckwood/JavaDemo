package com.example.demo.jdk8.p01_default_method_in_interface;

public class DefaultMethodDemo {
    public static void main(String[] args) {
        Vehicle car = new Car("BMW");
        System.out.println(car.getBrand());
        System.out.println(car.speedUp());
        System.out.println(car.slowDown());
        System.out.println(car.turnLightOn());
        System.out.println(car.turnLightOff());
    }
}
