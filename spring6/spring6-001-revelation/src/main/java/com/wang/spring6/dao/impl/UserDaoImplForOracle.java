package com.wang.spring6.dao.impl;

import com.wang.spring6.dao.UserDao;

/**
 * @Author:wsz
 * @Date: 2022/11/20 13:11
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class UserDaoImplForOracle implements UserDao {
    @Override
    public void deleteById() {
        System.out.println("oracle正在删除用户信息。。。。。。。。。。。。。。。。。");
    }
}
