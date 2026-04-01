package com.example.demo.encode.hex_string;

import java.nio.charset.StandardCharsets;

public class StringToHexStringConverter{

    private static final char[] HEX_ARRAY = "0123456789abcdef".toCharArray();

    /**
     * 将普通文本转换为 HEX 字符串
     * @param text 输入文本，例如 JSON 字符串
     * @return HEX 字符串
     */
    public static String textToHex(String text) {
        if (text == null) return null;
        // 使用 UTF-8 获取字节数组，这是目前最通用的标准
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
        return bytesToHex(bytes);
    }

    /**
     * 将 HEX 字符串还原为普通文本
     */
    public static String hexToText(String hex) {
        byte[] bytes = hexToBytes(hex);
        return new String(bytes, StandardCharsets.UTF_8);
    }

    // 辅助方法：字节转 HEX
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

    // 辅助方法：HEX 转字节
    public static byte[] hexToBytes(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    public static void main(String[] args) {
        convert("ee970aad570e4d4a");
        convert("3425032093234524");
        convert("Hi!");
    }

    public static void convert(String plain){

        // 1. 转换为 HEX
        String hexResult = textToHex(plain);
        System.out.println("文本内容: " + plain);
        System.out.println("对应 HEX: " + hexResult);

        // 2. 还原回文本
        String restoredText = hexToText(hexResult);
        System.out.println("还原文本: " + restoredText);

        System.out.println();
    }
}