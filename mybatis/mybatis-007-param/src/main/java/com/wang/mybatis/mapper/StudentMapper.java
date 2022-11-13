package com.wang.mybatis.mapper;

import com.wang.mybatis.pojo.Student;

import java.util.Date;
import java.util.List;

public interface StudentMapper {

    List<Student> selectStudentById(Integer id);
    List<Student> selectStudentByName(String name);
    List<Student> selectStudentByBirth(Date birth);
    List<Student> selectStudentBySex(Character sex);
}
