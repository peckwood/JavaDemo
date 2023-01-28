package com.example.demo.string.encoding_gbk;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class Demo {
    public static void main(String[] args) throws Exception {
        iso();
        System.out.println("=================================");
        gbk();
    }

    public static void iso() throws UnsupportedEncodingException {
        //这是一个unicode字符串，与字符集无关
        String str1 = "用户";

        System.out.println("unicode字符串：" + str1);

        //将str转为UTF-8字节流
        byte[] byteArray1 = str1.getBytes("UTF-8");//这个很安全，UTF-8不会造成数据丢失

        System.out.println(byteArray1.length);//打印6，没毛病

        //下面交给另外一个人，他不知道这是UTF-8字节流，因此他当做ISO-8859-1处理

        //将byteArray1当做一个普通的字节流，按照ISO-8859-1解码为一个unicode字符串
        String str2 = new String(byteArray1, "ISO-8859-1");

        System.out.println("转成ISO-8859-1会乱码：" + str2);

        //将ISO-8859-1编码的unicode字符串转回为byte[]
        byte[] byteArray2 = str2.getBytes("ISO-8859-1");//不会丢失数据

        //将字节流重新交回给用户A

        //重新用UTF-8解码
        String str3 = new String(byteArray2, "UTF-8");

        System.out.println("数据没有丢失：" + str3);
    }

    @Test
    public static void gbk() throws UnsupportedEncodingException {
        //这是一个unicode字符串，与字符集无关
        String str1 = "用户啊";
//        String str1 = "用户";

        System.out.println("unicode字符串：" + str1);

        //将str转为UTF-8字节流
        byte[] byteArray1 = str1.getBytes("UTF-8");//这个很安全，UTF-8不会造成数据丢失

        System.out.println(byteArray1.length);//打印6，没毛病

        //将byteArray1当做一个普通的字节流，按照GBK解码为一个unicode字符串
        String str2 = new String(byteArray1, "GBK");

        System.out.println("转成GBK会乱码：" + str2);

        //将GBK编码的unicode字符串转回为byte[]
        byte[] byteArray2 = str2.getBytes("GBK");//不会丢失数据

        //将字节流重新交回给用户A

        //重新用UTF-8解码
        String str3 = new String(byteArray2, "UTF-8");

        System.out.println("数据有没有丢失? " + str3);
    }
}
