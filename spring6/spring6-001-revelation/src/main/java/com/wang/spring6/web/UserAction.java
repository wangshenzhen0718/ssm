package com.wang.spring6.web;

import com.wang.spring6.service.UserService;
import com.wang.spring6.service.impl.UserServiceImpl;
/**
 * @Author:wsz
 * @Date: 2022/11/20 13:21
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class UserAction {

    private UserService userService=new UserServiceImpl();

    public void deleteRequest(){
        userService.deleteUser();
    }
}
