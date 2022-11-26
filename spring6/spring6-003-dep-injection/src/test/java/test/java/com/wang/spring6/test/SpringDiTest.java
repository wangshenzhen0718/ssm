package test.java.com.wang.spring6.test;

import com.wang.spring6.bean.Math;
import com.wang.spring6.bean.*;
import com.wang.spring6.jdbc.MyDataSource;
import com.wang.spring6.service.CustomerService;
import com.wang.spring6.service.OrderService;
import com.wang.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDiTest {

    @Test
    public void testUtil() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-util.xml");
        MyDataSource1 myDataSource1 = applicationContext.getBean("m1", MyDataSource1.class);
        MyDataSource2 myDataSource2 = applicationContext.getBean("m2", MyDataSource2.class);
        System.out.println(myDataSource1);
        System.out.println(myDataSource2);
    }

    @Test
    public void testC() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-c.xml");
        MyTime myTime = applicationContext.getBean("myTimeBean", MyTime.class);
        System.out.println(myTime);
    }
    @Test
    public void testP() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-p.xml");
        Dog dogBean = applicationContext.getBean("dogBean", Dog.class);
        System.out.println(dogBean);
    }

    @Test
    public void testSpecial() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-special.xml");
        Math mathBean = applicationContext.getBean("mathBean", Math.class);
        System.out.println(mathBean);
    }

    @Test
    public void testNull() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("set-di.xml");
        Cat cat = context.getBean("catBean", Cat.class);
        System.out.println(cat.getName().toUpperCase());
    }

    @Test
    public void testCollection() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-collection.xml");
        Person person = context.getBean("personBean", Person.class);
        System.out.println(person);
    }

    @Test
    public void testArray() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-array.xml");
        Person person = context.getBean("personBean", Person.class);
        System.out.println(person);
    }

    @Test
    public void testMyCasCade() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-cascade.xml");
        Student student = context.getBean("student", Student.class);
        Clazz clazz = context.getBean("clazzBean", Clazz.class);
        System.out.println(student);
        System.out.println(clazz);
    }

    @Test
    public void testMyDateSource() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-datasource.xml");
        MyDataSource dataSource = context.getBean("datasource", MyDataSource.class);
        System.out.println(dataSource);
    }

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
