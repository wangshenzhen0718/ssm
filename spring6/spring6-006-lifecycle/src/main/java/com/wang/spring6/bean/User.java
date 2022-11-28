package com.wang.spring6.bean;
/**
 * @Author:wsz
 * @Date: 2022/11/27 22:51
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class User {

    private String name;

    public User() {
        System.out.println("第一步 构造函数");
    }

    public void setName(String name) {
        System.out.println("第二步 set赋值");
        this.name = name;
    }
    public void initBean(){
        System.out.println("第四步 初始化bean");
    }

    public void destoryBean(){
        System.out.println("第七步 销毁bean");
    }
}
