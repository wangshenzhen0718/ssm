package com.wang.spring6.test;

import com.wang.spring6.bean.Student;
import com.wang.spring6.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleTest {

    /*spring只对singleton的Bean进行完整的生命周期管理
    如果是prototype作用域的Bean，Spring容器只负资将i该Bean初始化完毕。等客户端程序一旦获取到(Bean之后，Spring 容器就不再管理该对象的生命网期了*/
    @Test
    public void testLifecycle() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println("第六步 使用Bean");
        // 只有正常关闭spring容器才会执行销毁方法
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) applicationContext;
        context.close();
    }
    
    @Test
    public void testBeanRegister() {
        Student student = new Student();
        System.out.println(student);
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerSingleton("studentBean", student);
        Student studentBean = factory.getBean("studentBean", Student.class);
        System.out.println(studentBean);
    }
}
