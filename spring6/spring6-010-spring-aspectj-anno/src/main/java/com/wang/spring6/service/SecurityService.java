package com.wang.spring6.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class SecurityService {
    @Before("com.wang.spring6.service.LogAspect.pointCut())")
    public void advanceBefore(){
        System.out.println("前置 安全。。。。");
    }
}