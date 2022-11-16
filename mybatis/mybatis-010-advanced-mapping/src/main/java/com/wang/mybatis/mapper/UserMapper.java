package com.wang.mybatis.mapper;

import com.wang.mybatis.pojo.Groups;

import java.util.List;

/**
 * @Author:wsz
 * @Date: 2022/11/16 22:50
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public interface UserMapper {

    List<Groups> getUsers(Integer id);


}
