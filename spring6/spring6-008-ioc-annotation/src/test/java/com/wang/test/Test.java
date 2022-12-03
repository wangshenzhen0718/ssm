package com.wang.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    @org.junit.Test
    public void test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        Object userBean = context.getBean("user");
        Object orderDaoBean = context.getBean("orderDao");
        System.out.println(userBean);
        System.out.println(orderDaoBean);
    }

    @org.junit.Test
    public void testChoose(){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-choose.xml");
    }
}
