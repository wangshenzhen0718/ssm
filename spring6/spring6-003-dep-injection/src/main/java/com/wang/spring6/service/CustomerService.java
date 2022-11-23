package com.wang.spring6.service;

import com.wang.spring6.dao.UserDao;
import com.wang.spring6.dao.VipDao;


/**
 * @Author:wsz
 * @Date: 2022/11/23 20:49
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class CustomerService {

    public UserDao userDao;
    public VipDao vipDao;

    public CustomerService(UserDao userDao, VipDao vipDao) {
        this.userDao = userDao;
        this.vipDao = vipDao;
    }

    public void save() {

        userDao.insert();
        vipDao.updateVip();
    }

}
