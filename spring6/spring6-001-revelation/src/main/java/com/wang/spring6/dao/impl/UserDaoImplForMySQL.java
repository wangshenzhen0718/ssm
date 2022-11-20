package com.wang.spring6.dao.impl;

import com.wang.spring6.dao.UserDao;
/**
 * @Author:wsz
 * @Date: 2022/11/20 13:11
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class UserDaoImplForMySQL implements UserDao {
    @Override
    public void deleteById() {
        System.out.println("mysql正在删除用户信息。。。。。。。。。。。。。。。。。");
    }
}
