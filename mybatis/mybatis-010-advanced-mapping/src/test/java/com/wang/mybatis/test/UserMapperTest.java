package com.wang.mybatis.test;


import com.wang.mybatis.mapper.UserMapper;
import com.wang.mybatis.pojo.Groups;
import com.wang.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    private UserMapper userMapper = SqlSessionUtil.openSession().getMapper(UserMapper.class);

    @Test
    public void testSelectById() {
        List<Groups> users = userMapper.getUsers(1);
        users.forEach(user -> {
            System.out.println(user);
        });

    }


}
