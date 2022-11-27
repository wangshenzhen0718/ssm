package com.wang.spring6.bean;

import java.util.Date;
/**
 * @Author:wsz
 * @Date: 2022/11/27 15:29
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class Student {
    private Date birthday;

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "birthday=" + birthday +
                '}';
    }
}
