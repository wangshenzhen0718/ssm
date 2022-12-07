package com.wang.spring6.test;

import com.wang.spring6.service.OrderService;
import com.wang.spring6.service.Spring6Configuration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class APPTest {
    @Test
    public void test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(Spring6Configuration.class);
        OrderService orderService = context.getBean("orderService", OrderService.class);
        orderService.generate();
    }

}
