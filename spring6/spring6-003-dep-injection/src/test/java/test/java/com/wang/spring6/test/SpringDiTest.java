package test.java.com.wang.spring6.test;

import com.wang.spring6.bean.User;
import com.wang.spring6.service.CustomerService;
import com.wang.spring6.service.OrderService;
import com.wang.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDiTest {

    /*set注入简单类型测试*/
    @Test
    public void testSimpleDi() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("set-di.xml");
        User user = context.getBean("userBean", User.class);
        System.out.println(user);
    }
    /*set注入内部Bean和外部Bean测试*/
    @Test
    public void testSetDi2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("set-di.xml");
        OrderService orderService = context.getBean("orderServiceBean", OrderService.class);
        OrderService orderService2 = context.getBean("orderServiceBean2", OrderService.class);
        orderService.generate();
        orderService2.generate();
    }
    /*set注入测试*/
    @Test
    public void testSetDi() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = context.getBean("userServiceBean", UserService.class);
        userService.saveUser();
        userService.updateUser();

    }
    /*构造方法注入测试*/
    @Test
    public void testConstructorDi() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        CustomerService customerService = context.getBean("ctServiceBean", CustomerService.class);
        CustomerService customerService2 = context.getBean("ctServiceBean2", CustomerService.class);
        CustomerService customerService3 = context.getBean("ctServiceBean3", CustomerService.class);
        customerService.save();
        customerService2.save();
        customerService3.save();

    }

}
