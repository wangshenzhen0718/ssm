package com.wang.spring6.service;

import com.wang.spring6.dao.OrderDao;

/**
 * @Author:wsz
 * @Date: 2022/11/23 22:32
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class OrderService {
    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void generate(){
        orderDao.insert();
    }
}
