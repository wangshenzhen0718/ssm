package com.wang.client;

import com.wang.annotation.Component;

/**
 * @Author:wsz
 * @Date: 2022/12/2 23:12
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class ReflectAnnotationTest {
    public static void main(String[] args) throws Exception{

        Class<?> clazz = Class.forName("com.wang.bean.User");
        if (clazz.isAnnotationPresent(Component.class)){
            Component annotation = clazz.getAnnotation(Component.class);
            String value = annotation.value();
            System.out.println(value);
        }

    }
}
