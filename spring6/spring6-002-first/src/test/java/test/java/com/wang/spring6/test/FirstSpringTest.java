package test.java.com.wang.spring6.test;

import com.wang.spring6.bean.User;
import com.wang.spring6.bean.Vip;
import com.wang.spring6.dao.impl.UserDaoImplForMySQL;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FirstSpringTest {
    @Test
    public void testInitBean(){
        //注意:不是在调用getBean()方法的时候创建对象，电行以下代码的时候，就会实例化对象。
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml","bean.xml");
    }


    @Test
    public void testFirstSpringTest(){
        //第一步:获取Spring容器对象。
        // ApplicationContext:应用上下文。其实就是Spring 容器。
        // ApplicationContext是一个接口。
        // ApplicationContext 接口下有很多实现类。其中有一个实现类叫做:ClassPathXmlApplicationContext
        // ClassPathXmlApplicationContext 专门从类路径当中加载spring配置文件的一个Spring 上下文对象。
        // 初始化Spring容器上下文（解析beans.xml文件，创建所有的bean对象）
        //这行代码只要执行:就相当于启动了Spring容器，解析spring.xml文件，并且实例化所有的bean对象，放到spring容器当中。
        // Spring的IoC容器底层实际上使用了:工厂模式。
        // Spring底层的IoC是怎么实现的?XML解析＋工厂模式＋反射机制
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext ( "spring6.xml");

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml","bean.xml");
        //第二步:根据bean 的id 从Spring 容器中获取这个对象。
        User user = context.getBean("userBean",User.class);
        UserDaoImplForMySQL userDao = context.getBean("userDao", UserDaoImplForMySQL.class);
        Vip vipBean = context.getBean("vipBean", Vip.class);
        //如1果bean 的id不存在，不会返回null，而是出现异常。
        Date dateBean = context.getBean("dateBean", Date.class);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(dateBean);
        System.out.println(user);
        System.out.println(vipBean);
        System.out.println(userDao);
        System.out.println(dateBean);
        System.out.println(format);

    }
}
