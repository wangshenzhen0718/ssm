package com.wang.mybatis.mapper;

import com.wang.mybatis.pojo.Student;

/**
 * @Author:wsz
 * @Date: 2022/11/13 14:24
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public interface StudentMapper {

    Student getStudentById(Long id);
    Student getStudentByAssosition(Long id);


}
