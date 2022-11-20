package com.wang.spring6.service.impl;

import com.wang.spring6.dao.UserDao;
import com.wang.spring6.service.UserService;
/**
 * @Author:wsz
 * @Date: 2022/11/20 13:11
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class UserServiceImpl implements UserService {
    //UserDao userDao = new UserDaoImplForMySQL();
    //UserDao userDao = new UserDaoImplForOracle();

    private UserDao userDao;
    @Override
    public void deleteUser() {
        userDao.deleteById();
    }

}
