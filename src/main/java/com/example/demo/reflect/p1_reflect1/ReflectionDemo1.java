package com.example.demo.reflect.p1_reflect1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ReflectionDemo1 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        try {
            Class<?> studentClass = Class.forName("com.example.demo.reflect.p1_reflect1.Student");
            //get all public methods including parent methods
            Method[] allPublicMethods = studentClass.getMethods();
            System.out.println("allPublicMethods: ");
            Arrays.stream(allPublicMethods).forEach(method -> System.out.println(
                    String.format("name: %s, returnType: %s, modifiers: %s, parameters: %s",
                            method.getName(), method.getReturnType().getName(), Modifier.toString(method.getModifiers())
                            , Arrays.toString(method.getParameters()))));

            Method[] allDeclaredMethods = studentClass.getDeclaredMethods();
            System.out.println("\nall declared methods: ");
            Arrays.stream(allDeclaredMethods).forEach(method -> System.out.println(method.getName() ));

            Student student = new Student();
            student.setId(2L);
            student.setName("Riven");

            System.out.println("\nInvoke method getId: ");
            Method getIdMethod = studentClass.getMethod("getId");
            Object result = getIdMethod.invoke(student);
            System.out.println("Id after getId: " + result);

            System.out.println("\nInvoke method setName: ");
            Method setNameMethod = studentClass.getMethod("setName", String.class);
            setNameMethod.invoke(student, "Draven");
            System.out.println(student);

            //getFields只可以获取public field
            Field[] fields = studentClass.getFields();
            Arrays.stream(fields).forEach(field -> System.out.println("field name: " + field.getName()));

            System.out.println("\nSet field 'name': ");
            //getDeclaredField可以获取所有field
            Field field = studentClass.getDeclaredField("name");
            //to avoid IllegalAccessException when setting 'Akali'
            field.setAccessible(true);
            field.set(student, "Akali");
            System.out.println(student);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
