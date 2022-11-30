package com.wang.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        /**
         ● 调用哪个对象的（systemService）
         ● 哪个方法（login）
         ● 传什么参数（"admin", "admin123"）
         ● 返回什么值（success）
         * */
        // 创建对象

        Class<?> aClass = Class.forName("com.wang.reflect.SystemService");
        Method login = aClass.getDeclaredMethod("login", String.class, String.class);
        //调用obj对象的login方法传递 admin admin123参数  返回b
        Object obj = aClass.newInstance();
        Object b = login.invoke(obj,"admin", "admin123");
        System.out.println(b);
    }
}