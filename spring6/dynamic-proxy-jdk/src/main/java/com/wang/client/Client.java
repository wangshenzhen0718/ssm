package com.wang.client;

import com.wang.mall.service.OrderService;
import com.wang.mall.service.OrderServiceImpl;
import com.wang.mall.service.TimerInvocationHandler;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        // 一 创建目标对象
        OrderService target = new OrderServiceImpl();
        // 二 创建代理对象
        /**
         第1个参数:ClassLoader loader类加载器。在内存中生成了字节码，要想执行这个字节码，也是需要先把这个字节码加载到内存当中的。
         所以要指定使用哪个类加载器加载。并且JDK要求，目标类的类加载器必须和代理类的类加载器使用同一个。
         第2个参数:Class<?>[] interfaces接口类型。代理类和目标类实现相同的接口，所以要通过这个参数告诉JDK动态代理生成的类要实现哪些接口。
         第3个参数: InvocationHandler h
         InvocationHandler被翻译为:调用处理器。是一个接口。在调用处理器接口中编写的就是:增强代码
         因为具体要增强什么代码，JDK动态代理技术它是猜不到的。没有那么神。
         */
        OrderService o = (OrderService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new TimerInvocationHandler(target));
        // 三 调用代理对象的代理方法
        o.generate();
        o.modify();
        o.detail();
        String name = o.getName();
        System.out.println(name);

    }
}
