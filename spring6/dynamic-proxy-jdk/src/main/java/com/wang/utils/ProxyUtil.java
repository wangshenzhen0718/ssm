package com.wang.utils;

import com.wang.mall.service.TimerInvocationHandler;

import java.lang.reflect.Proxy;

public class ProxyUtil {

    public static Object newProxyInstance(Object target){
        Object o = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new TimerInvocationHandler(target));
        return o;

    }
}
