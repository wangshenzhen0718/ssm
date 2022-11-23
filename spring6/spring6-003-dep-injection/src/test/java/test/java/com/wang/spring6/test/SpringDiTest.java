package test.java.com.wang.spring6.test;

import com.wang.spring6.service.CustomerService;
import com.wang.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDiTest {
    @Test
    public void testSetDi() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = context.getBean("userServiceBean", UserService.class);
        userService.saveUser();
        userService.updateUser();

    }

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
