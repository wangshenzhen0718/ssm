package com.wang.myspring.bean;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
public class UserService {

    private UserDao userDao;
    public void save(){
        userDao.save();
    }

}
