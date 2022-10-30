package com.wang.junit.service;

import com.wang.service.MathService;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author:wsz
 * @Date: 2022/10/29 21:23
 * @Description:单元测试类
 * @Version: 1.0
 * @Since: 1.0
 */
public class MathServiceTest {

    //单元测试方法写多少个。
    //一般是一个业务方法对应一个测试方式。
    //测试方法的规范:public void testXxxX()0}
    // 测试方法的方法名:以test开始。假设测试的方法是sum，这个测试方法名: testsum
    @Test
    public void testSum() {
        //单元测试中有两个重要的概念:
        //一个是:实际值（被测试的业务方法的真正执行结果)
        //一个是:期望值（执行了这个业务方法之后，你期望的执行结果是多少)
        MathService mathService = new MathService();
        int actual = mathService.sum(10, 5);
        int expect = 15;
        Assert.assertEquals(expect, actual);
    }
    @Test
    public void testAbs() {
        MathService mathService = new MathService();
        int actual = mathService.abs(10, 5);
        int expect = 5;
        Assert.assertEquals(expect, actual);

    }
}
