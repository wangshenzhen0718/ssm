package org.wang.dao.impl;

import org.springframework.stereotype.Repository;
import org.wang.dao.OrderDao;
@Repository("orderDaoImpl")
public class OrderDaoImpl implements OrderDao {
    @Override
    public void save() {
        System.out.println("mysql保存数据");
    }
}
