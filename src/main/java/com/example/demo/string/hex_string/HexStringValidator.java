package com.example.demo.string.hex_string;

import org.junit.Test;

public class HexStringValidator{
    @Test
    public void validate(){
        for (String string : StringContainer.getStringList()){
            if(!isValidHexPerformance(string)){
                System.out.printf("'%s' is not valid%n", string);
            }
        }
    }

    public static boolean isValidHex(String data) {
        if (data == null) {
            return false;
        }
        // Matches only 0-9, a-f, A-F and ensures an even length
        return data.matches("^[0-9a-fA-F]*$") && (data.length() % 2 == 0);
    }

    public static boolean isValidHexPerformance(String data) {
        if (data == null || data.length() % 2 != 0) {
            return false;
        }
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            boolean isDigit = (c >= '0' && c <= '9');
            boolean isHexAlpha = (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');

            if (!isDigit && !isHexAlpha) {
                return false;
            }
        }
        return true;
    }
}
