package com.example.demo.thirdparty.org.apache.commons.beanutils;

import org.apache.commons.beanutils.BeanUtils;

public class Demo {
    public static void main(String[] args) throws Exception{
        MyObject source = new MyObject();
        source.setInteger1(1);
        source.setBoolean1(false);
        MyObject target = new MyObject();
            BeanUtils.copyProperties(target, source);
//            PropertyUtils.copyProperties(source, target);
        System.out.println(target);
    }
}
