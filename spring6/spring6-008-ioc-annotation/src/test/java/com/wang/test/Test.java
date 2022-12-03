package com.wang.test;

import cn.wang.service.StudentService;
import com.wang.bean3.MyDataSource;
import com.wang.bean3.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.wang.service.OrderService;

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

    @org.junit.Test
    public void testAutoWired(){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-autowired.xml");
        OrderService orderService = context.getBean("orderService", OrderService.class);
        orderService.generate();
    }

    @org.junit.Test
    public void testResource(){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-resource.xml");
        StudentService studentService = context.getBean("studentService", StudentService.class);
        studentService.deleteStudent();
    }
}
