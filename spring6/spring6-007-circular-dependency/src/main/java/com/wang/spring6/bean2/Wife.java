package com.wang.spring6.bean2;

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

    public Wife(String name, Husband husband) {
        this.name = name;
        this.husband = husband;
    }

    @Override
    public String toString() {
        return "Wife{" +
                "name='" + name + '\'' +
                ", husband=" + husband.getName() +
                '}';
    }
}
