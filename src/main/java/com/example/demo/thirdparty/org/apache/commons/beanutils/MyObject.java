package com.example.demo.thirdparty.org.apache.commons.beanutils;

public class MyObject {
    private Integer integer1;
    private Integer integer2;
    private Boolean boolean1;
    private Boolean boolean2;

    public Integer getInteger1() {
        return integer1;
    }

    public void setInteger1(Integer integer1) {
        this.integer1 = integer1;
    }

    public Boolean getBoolean1() {
        return boolean1;
    }

    public void setBoolean1(Boolean boolean1) {
        this.boolean1 = boolean1;
    }

    public Integer getInteger2() {
        return integer2;
    }

    public void setInteger2(Integer integer2) {
        this.integer2 = integer2;
    }

    public Boolean getBoolean2() {
        return boolean2;
    }

    public void setBoolean2(Boolean boolean2) {
        this.boolean2 = boolean2;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "integer1=" + integer1 +
                ", integer2=" + integer2 +
                ", boolean1=" + boolean1 +
                ", boolean2=" + boolean2 +
                '}';
    }
}
