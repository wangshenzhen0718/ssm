package com.wang.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:wsz
 * @Date: 2022/11/14 21:51
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Integer sid;
    private String sname;
    private Clazz clazz;
}
