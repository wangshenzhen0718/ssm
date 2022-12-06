package com.wang.spring6.test;

import com.wang.spring6.service.OrderService;
import com.wang.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aspectj-aop-annotation.xml");
        UserService userService = context.getBean("userService", UserService.class);
        OrderService orderService = context.getBean("orderService", OrderService.class);
        /*userService.login();
        userService.logout();*/
        orderService.generate();
    }
}
