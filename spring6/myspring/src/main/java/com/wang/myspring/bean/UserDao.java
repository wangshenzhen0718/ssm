package com.wang.myspring.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:wsz
 * @Date: 2022/12/1 20:59
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
@Data
@NoArgsConstructor
public class UserDao {
    public void save(){
        System.out.println("保存数据。。。。。。。。");
    }

}
