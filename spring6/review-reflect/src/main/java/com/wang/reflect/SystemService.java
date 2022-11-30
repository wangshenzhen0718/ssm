package com.wang.reflect;

public class SystemService {
    
    public void logout(){
        System.out.println("退出系统");
    }

    public boolean login(String username, String password){
        if ("admin".equals(username) && "admin123".equals(password)) {
            return true;
        }
        return false;
    }
}