package com.wang.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest04 {
    public static void main(String[] args) throws Exception {
        String className="com.wang.reflect.User";
        String propertyName="age";
        Class<?> aClass = Class.forName(className);
        String methodName = "set"+propertyName.toUpperCase().charAt(0)+propertyName.substring(1);
        //根据名称获取属性信息
        Field field = aClass.getDeclaredField("age");
        Method setMethod = aClass.getDeclaredMethod(methodName,field.getType());
        Object o = aClass.newInstance();
        setMethod.invoke(o, 30);
        System.out.println(o);


    }
}