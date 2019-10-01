package com.bladespear.demo.reflect.p2_oracle_tutorial.classes;

import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

import static java.lang.System.out;

public class ExaminingClassModifierAndType {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("java.lang.Character");
            String modifiers = Modifier.toString(clazz.getModifiers());
            out.println("modifiers: " + modifiers);

            TypeVariable<? extends Class<?>>[] typeParameters = clazz.getTypeParameters();
            if(typeParameters.length != 0){
                Arrays.stream(typeParameters).forEach(typeParameter -> out.println(typeParameter.getName()));
            }else{
                out.format("  -- No Type Parameters --%n%n");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
