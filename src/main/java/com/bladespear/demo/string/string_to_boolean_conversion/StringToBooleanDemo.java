package com.bladespear.demo.string.string_to_boolean_conversion;

public class StringToBooleanDemo {
    public static void main(String[] args) {
        String trueString = "true";

        //boolean a = (boolean) trueString;
        //Boolean b = (Boolean) trueString;
        boolean c = Boolean.valueOf(trueString);
    }
}
