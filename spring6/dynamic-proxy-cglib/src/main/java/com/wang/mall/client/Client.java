package com.wang.mall.client;

import com.wang.mall.service.TimerMethodInterceptor;
import com.wang.mall.service.UserService;
import net.sf.cglib.proxy.Enhancer;

/**
 * @Author:wsz
 * @Date: 2022/12/5 20:38
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class Client {

    /**
     * 对于高版本的JDK，如果使用CGLIB，需要在启动项中添加两个启动参数：
     * ● --add-opens java.base/java.lang=ALL-UNNAMED
     * ● --add-opens java.base/sun.net.util=ALL-UNNAMED
     */
    public static void main(String[] args) {
        // 创建字节码增强器
        Enhancer enhancer = new Enhancer();
        // 告诉cglib要继承哪个类
        enhancer.setSuperclass(UserService.class);
        // 设置回调接口
        enhancer.setCallback(new TimerMethodInterceptor());
        UserService userService = (UserService) enhancer.create();
        //建议大家能够把CGLIB动态代理生成的代理对象的名字格式有点印象。
        //根据这个名字可以推测框架底层是否使用了CGLIB动态代理
        System.out.println(userService);
        userService.login();
        userService.logout();
    }
}
