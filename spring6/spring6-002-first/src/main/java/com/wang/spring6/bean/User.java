package com.wang.spring6.bean;

/**
 * @Author:wsz
 * @Date: 2022/11/20 21:08
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class User {
    //Spring是怎么实例化对象的?
    //默认情况下Spring会通过反射机制，调用类的无参数构造方法来实例化对象。
    //实现原理如下:
    //Class clazz = Class.forName("com.wang.spring6.bean.User" );
    // Object obj = clazz.newInstance();

    public User() {
        System.out.println("无参构造方法");
    }
}
