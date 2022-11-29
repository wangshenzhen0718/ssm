package com.wang.spring6.bean;

/**
 * @Author:wsz
 * @Date: 2022/11/29 20:06
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class Wife {
    private String name;
    private Husband husband;

    public String getName() {
        return name;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Wife{" +
                "name='" + name + '\'' +
                ", husband=" + husband.getName() +
                '}';
    }
}
