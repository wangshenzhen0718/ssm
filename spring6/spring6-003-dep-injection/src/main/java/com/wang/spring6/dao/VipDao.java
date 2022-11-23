package com.wang.spring6.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author:wsz
 * @Date: 2022/11/23 20:11
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class VipDao {

    private static final Logger logger = LoggerFactory.getLogger(VipDao.class);

    public void updateVip() {
        logger.info("数据库正在修改用户数据。");
    }
}
