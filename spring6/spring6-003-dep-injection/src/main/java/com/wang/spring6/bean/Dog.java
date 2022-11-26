package com.wang.spring6.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author:wsz
 * @Date: 2022/11/26 13:20
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dog {
    private String name;
    private int age;
    private Date birth;
}
