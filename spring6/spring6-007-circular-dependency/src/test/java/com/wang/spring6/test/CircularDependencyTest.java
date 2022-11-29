package com.wang.spring6.test;

import com.wang.spring6.bean.Husband;
import com.wang.spring6.bean.Wife;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CircularDependencyTest {

    @Test
    public void testSingletonAndSet(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Husband husbandBean = applicationContext.getBean("husband", Husband.class);
        Wife wifeBean = applicationContext.getBean("wife", Wife.class);
        System.out.println(husbandBean);
        System.out.println(wifeBean);
    }
}
