package com.wang.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest03 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        /**
         ● 调用哪个对象的（systemService）
         ● 哪个方法（login）
         ● 传什么参数（"admin", "admin123"）
         ● 返回什么值（success）
         * */
        Class<?> aClass = Class.forName("com.wang.reflect.SystemService");
        Method logout = aClass.getDeclaredMethod("logout");
        Object obj = aClass.newInstance();
        logout.invoke(obj);
    }
}