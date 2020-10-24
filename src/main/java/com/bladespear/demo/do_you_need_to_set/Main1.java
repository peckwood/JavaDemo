package com.bladespear.demo.do_you_need_to_set;

import java.util.ArrayList;
import java.util.List;

/**
 * You can not change the object the reference is pointing to,
 * you have to change the object with setter
 */
public class Main1 {
    public static void main(String[] args) {
        ParentObject p = new ParentObject();
        List l = new ArrayList<>();
        p.setList(l);

        System.out.println();
        p.getList().add(1);
        System.out.println(p);

        System.out.println("==================================");

        ParentObject q = new ParentObject();
        q.setList(null);
        List l1 = q.getList();
        l1 = new ArrayList<>(1);

        System.out.println("q: " + q);




    }
}
