package com.bladespear.demo.double11;

import java.util.List;

public class Bonus {
    private int id;
    private int level;
    private int order;
    private List<Long> couponList;

    public Bonus(int id, int level, int order, List<Long> couponList) {
        this.id = id;
        this.level = level;
        this.order = order;
        this.couponList = couponList;
    }
}
