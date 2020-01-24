package com.example.demo.reflect.p2_oracle_tutorial.classes;

import java.io.PrintStream;
import java.util.Arrays;

public class RetrieveClassObject {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        //object.getClass()
        Class<? extends String> stringClass = "a".getClass();
        Class<? extends PrintStream> printStreamClass = System.out.getClass();
        byte[] bytes= new byte[2];
        Class<? extends byte[]> byteArrayClass = bytes.getClass();

        //.class syntax
        Class<Integer> integerClass = int.class;
        Class<String> stringClass1 = String.class;
        Class<int[][]> multiDimensionClass = int[][].class;

        //Get class object from fully qualified name
        try {
            Class hashMapClass = Class.forName("java.util.HashMap");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //TYPE Field for Primitive Type Wrappers
        Class<Double> doubleClass = Double.TYPE;
        Class<Double> doubleClass1 = double.class;
        System.out.println("double.class.equals(Double.TYPE): " + doubleClass.equals(doubleClass1));
        System.out.println("void.class.equals(Void.TYPE): " + void.class.equals(Void.TYPE));

        //Methods that return classes
        Class<?> objectclass = stringClass.getSuperclass();
        System.out.println("String's superclass is: " + objectclass.getName());
        Class<?> objectclassParent = objectclass.getSuperclass();
        System.out.println("Object's superclass is : " + objectclassParent);

        //Get all public class/interface/enum that are members of this class
        System.out.println("\nCharacter class's class members");
        Class<?>[] classes = Character.class.getClasses();
        Arrays.stream(classes).forEach(c -> System.out.println(c.getName()));

        //Get all class/interface/enum that are members of this class
        System.out.println("\nCharacter class's declared classes members(including private)");
        Class<?>[] declaredClasses = Character.class.getDeclaredClasses();
        Arrays.stream(declaredClasses).forEach(c -> System.out.println(c.getName()));

        //get declaring class, where the class/field/method/constructor is declared
        System.out.println("\nThe declaring class of field 'out': " + System.class.getField("out").getDeclaringClass());
        System.out.println();

        System.out.println("Thread.State.class.getEnclosingClass(): " + Thread.State.class.getEnclosingClass());
    }
}
