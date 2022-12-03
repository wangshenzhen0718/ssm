package com.wang.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    @org.junit.Test
    public void test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        Object userBean = context.getBean("user");
        System.out.println(userBean);
    }
}
