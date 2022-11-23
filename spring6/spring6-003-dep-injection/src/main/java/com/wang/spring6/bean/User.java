package com.wang.spring6.bean;
/**
 * @Author:wsz
 * @Date: 2022/11/23 22:58
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class User {
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }

    private String username;
    private String password;
    private int age;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
