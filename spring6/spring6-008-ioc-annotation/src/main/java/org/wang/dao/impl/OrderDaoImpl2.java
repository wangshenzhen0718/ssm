package org.wang.dao.impl;

import org.springframework.stereotype.Repository;
import org.wang.dao.OrderDao;

@Repository("orderDaoImpl2")
public class OrderDaoImpl2 implements OrderDao {
    @Override
    public void save() {
        System.out.println("oracle保存数据");
    }
}
