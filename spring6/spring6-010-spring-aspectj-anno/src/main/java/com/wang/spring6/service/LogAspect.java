package com.wang.spring6.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author:wsz
 * @Date: 2022/12/6 20:47
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */

// 切面类
@Component("logAspect")
@Aspect
@Order(2)
public class LogAspect {
    //通用切点表达式
    @Pointcut("execution(* com.wang.spring6.service..*(..))")
    public void pointCut(){}
    //切面=通知+切点

    @Before("pointCut()")
    public void advanceBefore(JoinPoint joinPoint) {
        System.out.println("这是一段前置代码！！！");
        System.out.println(joinPoint.getSignature());
    }

    @AfterReturning("pointCut()")
    public void advanceAfterReturning() {
        System.out.println("这是一段后置代码！！！");
    }
    @Around("pointCut()")
    public void advanceAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("这是一段环绕开始代码！！！");
        proceedingJoinPoint.proceed();
        System.out.println("这是一段环绕结束代码！！！");
    }
    @After("pointCut()")
    public void advanceAfter() {
        System.out.println("这是一段最终通知代码！！！");
    }

    @AfterThrowing("pointCut()")
    public void advanceAfterThrowing() {
        System.out.println("这是一段异常通知代码！！！");
    }
}
