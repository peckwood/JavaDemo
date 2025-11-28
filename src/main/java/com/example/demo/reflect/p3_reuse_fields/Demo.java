package com.example.demo.reflect.p3_reuse_fields;

import com.example.demo.reflect.p1_reflect1.Student;

import java.lang.reflect.Field;

/**
 * you don't need to set field to accessible for every object
 */
public class Demo{
    public static void main(String[] args) throws IllegalAccessException{
        Student student = new Student();
        student.setId(1);
        Student student2 = new Student();
        student2.setId(2);

        Field[] fields = student.getClass().getDeclaredFields();
        fields[0].setAccessible(true);

        fields[0].set(student2, 3);

        System.out.println("student2" + student2);
    }
}
