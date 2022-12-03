package org.wang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.wang.dao.OrderDao;

/**
 * @Author:wsz
 * @Date: 2022/12/3 16:07
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
@Service
public class OrderService {
    @Autowired
    //有多个实现时根据名称
    @Qualifier("orderDaoImpl2")
    private OrderDao orderDao;
    public void generate(){
        orderDao.save();

    }
}
