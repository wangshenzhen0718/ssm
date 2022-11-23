package com.wang.spring6.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author:wsz
 * @Date: 2022/11/22 22:45
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    public void insert() {
        logger.info("数据库正在保存用户数据。");
    }
}
