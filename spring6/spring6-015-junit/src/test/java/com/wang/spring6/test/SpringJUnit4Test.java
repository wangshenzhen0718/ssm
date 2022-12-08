package com.wang.spring6.test;

import com.wang.spring6.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class SpringJUnit4Test {
    /*
    Spring提供的方便主要是这几个注解：
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration("classpath:spring.xml")
    在单元测试类上使用这两个注解之后，在单元测试类中的属性上可以使用@Autowired。比较方便。
    * */
    @Autowired
    private User user;

    @Test
    public void test() {

        /*ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        User user = context.getBean("user", User.class);*/
        System.out.println(user.getName());

    }
}
