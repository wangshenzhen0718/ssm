package com.wang.spring6.test;

import com.wang.spring6.bean.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring.xml")
public class SpringJUnit5Test {
    @Autowired
    private User user;

    @Test
    public void test() {

        /*ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        User user = context.getBean("user", User.class);*/
        System.out.println(user.getName());

    }
}
