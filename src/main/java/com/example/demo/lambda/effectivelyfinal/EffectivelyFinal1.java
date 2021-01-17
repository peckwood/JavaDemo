package com.example.demo.lambda.effectivelyfinal;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

public class EffectivelyFinal1{
    public static void main(String[] args){
        b();
    }

    // problem
    private static void a(){
        int integer1 = 1;
        Supplier<Integer> supplier1 = (() ->{
            //Variable used in lambda expression should be final or effectively final
            //integer1 = 2;
            return integer1;
        });
    }

    // solution
    private static void b(){
        int integer1 = 1;
        final AtomicReference<Integer> reference = new AtomicReference<>();
        reference.set(integer1);
        Supplier<Integer> supplier1 = (() ->{
            //Variable used in lambda expression should be final or effectively final
            //integer1 = 2;
            Integer integer1Reference = reference.get();
            integer1Reference = 2;
            return integer1Reference;
        });
        System.out.println(supplier1.get());
    }
}
