package com.wang.spring6.test;

import com.wang.spring6.bean.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringInstantiationTest {

    @Test
    public void testFactoryBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
    }

    /*
    BeanFactory和FactoryBean的区别
    BeanFactory是工厂
        Spring IoC容器的顶级对象，BeanFactory被翻译为“Bean工厂”，在Spring的IoC容器中，“Bean工厂”负责创建Bean对象。
    FactoryBean
    FactoryBean：它是一个Bean，是一个能够辅助Spring实例化其它Bean对象的一个Bean。
    在Spring中，Bean可以分为两类：
        ● 第一类：普通Bean
        ● 第二类：工厂Bean（记住：工厂Bean也是一种Bean，只不过这种Bean比较特殊，它可以辅助Spring实例化其它Bean对象。*/

    @Test
    public void testInstantiation4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }

    @Test
    public void testInstantiation3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Gun gun = context.getBean("gun", Gun.class);
        System.out.println(gun);
    }

    @Test
    public void testInstantiation2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Star star = context.getBean("starFactory", Star.class);
        System.out.println(star);
    }

    @Test
    public void testInstantiation1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        SpringBean springBean = context.getBean("springBean", SpringBean.class);
        System.out.println(springBean);
    }
}
