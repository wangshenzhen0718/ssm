package test.java.com.wang.spring6.test;

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

}
