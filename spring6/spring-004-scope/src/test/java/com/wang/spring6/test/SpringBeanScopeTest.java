package com.wang.spring6.test;

import com.wang.spring6.bean.SpringBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanScopeTest {
    @Test
    public void test() {
        /*Spring的IoC容器中，默认情况下，Bean对象是单例的。
        默认情况下，Bean对象的创建是在初始化Spring上下文的时候就完成的。*/
        ApplicationContext context =new ClassPathXmlApplicationContext("spring-scope.xml");
        SpringBean springBean = context.getBean("springBean", SpringBean.class);
        SpringBean springBean2 = context.getBean("springBean", SpringBean.class);
        System.out.println(springBean);
        System.out.println(springBean2);
    }
}
