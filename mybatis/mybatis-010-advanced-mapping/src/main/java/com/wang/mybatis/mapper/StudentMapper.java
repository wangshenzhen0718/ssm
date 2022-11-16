package com.wang.mybatis.mapper;

import com.wang.mybatis.pojo.Student;

import java.util.List;

/**
 * @Author:wsz
 * @Date: 2022/11/13 14:24
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public interface StudentMapper {

    Student getStudentById(Integer id);
    Student getStudentByAssosition(Integer id);
    Student selectBySidStep1(Integer id);

    List<Student> selectByCidStep2(Integer cid);


}
