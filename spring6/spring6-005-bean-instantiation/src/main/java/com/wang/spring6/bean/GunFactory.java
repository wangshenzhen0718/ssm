package com.wang.spring6.bean;
/**
 * @Author:wsz
 * @Date: 2022/11/27 13:46
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class GunFactory {
    public GunFactory() {
        System.out.println("GunFactory的无参构造方法被执行！！！");
    }
    public Gun get(){
        return new Gun();
    }
}
