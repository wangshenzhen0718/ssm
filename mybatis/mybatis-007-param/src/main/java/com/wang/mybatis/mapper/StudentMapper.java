package com.wang.mybatis.mapper;

import com.wang.mybatis.pojo.Student;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StudentMapper {

    List<Student> selectStudentById(Integer id);
    List<Student> selectStudentByName(String name);
    List<Student> selectStudentByBirth(Date birth);
    List<Student> selectStudentBySex(Character sex);
    int insertStudentByMap(Map map);
}
