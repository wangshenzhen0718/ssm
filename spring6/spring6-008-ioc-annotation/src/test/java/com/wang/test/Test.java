package com.wang.test;

import com.wang.bean3.MyDataSource;
import com.wang.bean3.Product;
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

    @org.junit.Test
    public void testDI(){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-di-annotation.xml");
        MyDataSource myDataSource = context.getBean("myDataSource", MyDataSource.class);
        System.out.println(myDataSource);
    }

    @org.junit.Test
    public void testMethodDI(){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-di-annotation.xml");
        Product product = context.getBean("product", Product.class);
        System.out.println(product);
    }
}
