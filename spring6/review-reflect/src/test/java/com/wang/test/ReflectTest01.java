package com.wang.test;

import com.wang.reflect.SystemService;

public class ReflectTest01 {
    public static void main(String[] args) {

        /**
         ● 调用哪个对象的（systemService）
         ● 哪个方法（login）
         ● 传什么参数（"admin", "admin123"）
         ● 返回什么值（success）
         * */
        // 创建对象
        SystemService systemService = new SystemService();

        // 调用方法并接收方法的返回值
        boolean success = systemService.login("admin", "admin123");

        System.out.println(success ? "登录成功" : "登录失败");
    }
}