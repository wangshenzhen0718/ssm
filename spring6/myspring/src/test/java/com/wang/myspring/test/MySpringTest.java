package com.wang.myspring.test;

import com.wang.myspring.bean.UserService;
import org.junit.Test;
import org.myspringframework.core.ApplicationContext;
import org.myspringframework.core.ClassPathXmlApplicationContext;

public class MySpringTest {
    @Test
    public void testMySpring(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("myspring.xml");
        Object userBean = applicationContext.getBean("userBean");
        Object userDaoBean = applicationContext.getBean("userDaoBean");
        UserService userServiceBean = (UserService) applicationContext.getBean("userServiceBean");
        System.out.println(userBean);
        System.out.println(userDaoBean);
        userServiceBean.save();
    }
}