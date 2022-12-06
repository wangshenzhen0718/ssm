package com.wang.spring6.service;

import org.springframework.stereotype.Service;

/**
 * @Author:wsz
 * @Date: 2022/12/6 20:45
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
@Service("userService")
public class UserService {//目标类
    //目标方法
    public void login() {
        System.out.println("系统正在登陆、、、、、");
    }

    public void logout() {
        System.out.println("系统正在退出、、、、、");
    }
}
