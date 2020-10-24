package com.example.demo.do_you_need_to_set;

import java.util.List;

public class ParentObject {
    private List<Integer> list;

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        System.out.println("setter called");
        this.list = list;
    }

    @Override
    public String toString() {
        return "ParentObject{" +
                "list=" + list +
                '}';
    }
}
