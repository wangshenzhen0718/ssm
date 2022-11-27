package com.wang.spring6.bean;

/**
 * @Author:wsz
 * @Date: 2022/11/27 11:45
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class StarFactory {
    public StarFactory() {
        System.out.println("StarFactory 被初始化");
    }

    public static Star get() {
        return new Star();
    }
}
