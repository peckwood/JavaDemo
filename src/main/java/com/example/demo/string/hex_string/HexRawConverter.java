package com.example.demo.string.hex_string;

import java.nio.charset.StandardCharsets;

public class HexRawConverter {

    private static final char[] HEX_ARRAY = "0123456789abcdef".toCharArray();

    /**
     * 1. 将 32 位 Hex 字符串转换为 16 位原始字符串 (128 bit)
     */
    public static String hex32ToRaw16(String hex) {
        byte[] bytes = hexToBytes(hex);
        // 使用 ISO-8859-1 确保每个字节直接映射为一个字符，不发生编码转换
        return new String(bytes, StandardCharsets.ISO_8859_1);
    }

    /**
     * 2. 将 16 位原始字符串还原为 32 位 Hex 字符串
     */
    public static String raw16ToHex32(String raw) {
        byte[] bytes = raw.getBytes(StandardCharsets.ISO_8859_1);
        return bytesToHex(bytes);
    }

    /**
     * 辅助方法：Hex 字符串转字节数组
     */
    public static byte[] hexToBytes(String s) {
        int len = s.length();
        if (len % 2 != 0) {
            throw new IllegalArgumentException("Hex string 长度必须为偶数");
        }
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    /**
     * 辅助方法：字节数组转 Hex 字符串
     */
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static void main(String[] args) {
        String originalHex = "a133256c7fafff108731a110af89d1e8";
        
        // 转换
        String rawString = hex32ToRaw16(originalHex);
        System.out.println("原始 Hex 长度: " + originalHex.length()); // 32
        System.out.println("生成字符串长度: " + rawString.length());     // 16
        System.out.println("rawString: " + rawString);     // 16

        // 还原
        String restoredHex = raw16ToHex32(rawString);
        System.out.println("还原后的 Hex: " + restoredHex);
        System.out.println("是否匹配: " + originalHex.equals(restoredHex));
    }
}