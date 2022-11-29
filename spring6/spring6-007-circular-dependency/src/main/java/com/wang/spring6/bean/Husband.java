package com.wang.spring6.bean;

/**
 * @Author:wsz
 * @Date: 2022/11/29 20:05
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */

public class Husband {
    @Override
    public String toString() {
        return "Husband{" +
                "name='" + name + '\'' +
                ", wife=" + wife.getName() +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private Wife wife;
}
