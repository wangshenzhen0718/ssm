package com.wang.spring6.bean2;

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

    public Husband(String name, Wife wife) {
        this.name = name;
        this.wife = wife;
    }

    private String name;
    private Wife wife;
}
