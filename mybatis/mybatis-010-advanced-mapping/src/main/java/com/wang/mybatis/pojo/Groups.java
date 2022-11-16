package com.wang.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @Author:wsz
 * @Date: 2022/11/16 22:48
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Groups {
    private int gid;

    private String gname;

    private Set<Users> users;
}
