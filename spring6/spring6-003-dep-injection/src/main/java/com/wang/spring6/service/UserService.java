package com.wang.spring6.service;

import com.wang.spring6.dao.UserDao;
import com.wang.spring6.dao.VipDao;

/**
 * @Author:wsz
 * @Date: 2022/11/22 22:54
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */

public class UserService {

    public UserDao userDao;
    public VipDao vipDao;

    public void setVipDao(com.wang.spring6.dao.VipDao vipDao) {
        this.vipDao = vipDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    // 使用set方式注入，必须提供set方法。
    // 反射机制要调用这个方法给属性赋值的。
    //自定义set方法
    /*public void setSqlUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/

    public void saveUser() {

        userDao.insert();
    }

    public void updateUser() {
        vipDao.updateVip();
    }
}
