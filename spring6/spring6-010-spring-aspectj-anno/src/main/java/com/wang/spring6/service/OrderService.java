package com.wang.spring6.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    // 目标方法
    public void generate(){
        System.out.println("订单已生成！");
        if (1==1){
            //异常后 后环绕无效
            throw new RuntimeException();
        }
    }
}