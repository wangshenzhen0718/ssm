package com.wang.spring6.test;

import com.wang.spring6.bean.Gun;
import com.wang.spring6.bean.Person;
import com.wang.spring6.bean.SpringBean;
import com.wang.spring6.bean.Star;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringInstantiationTest {

    @Test
    public void testInstantiation4(){
        ApplicationContext context =new ClassPathXmlApplicationContext("spring.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }

    @Test
    public void testInstantiation3(){
        ApplicationContext context =new ClassPathXmlApplicationContext("spring.xml");
        Gun gun = context.getBean("gun", Gun.class);
        System.out.println(gun);
    }

    @Test
    public void testInstantiation2(){
        ApplicationContext context =new ClassPathXmlApplicationContext("spring.xml");
        Star star = context.getBean("starFactory", Star.class);
        System.out.println(star);
    }

    @Test
    public void testInstantiation1(){
        ApplicationContext context =new ClassPathXmlApplicationContext("spring.xml");
        SpringBean springBean = context.getBean("springBean", SpringBean.class);
        System.out.println(springBean);
    }
}
