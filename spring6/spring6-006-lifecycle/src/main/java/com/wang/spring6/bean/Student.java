package com.wang.spring6.bean;

/**
 * @Author:wsz
 * @Date: 2022/11/27 22:51
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class Student {

    private String name;

    public Student() {
        System.out.println("构造函数 Student");
    }

    public void setName(String name) {
        System.out.println("set赋值");
        this.name = name;
    }


}
