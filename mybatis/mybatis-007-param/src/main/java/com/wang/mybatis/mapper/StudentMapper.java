package com.wang.mybatis.mapper;

import com.wang.mybatis.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StudentMapper {

    List<Student> selectStudentById(Integer id);

    List<Student> selectStudentByName(String name);

    List<Student> selectStudentByBirth(Date birth);

    List<Student> selectStudentBySex(Character sex);

    int insertStudentByMap(Map map);

    int insertStudentByPojo(Student student);

    /*多参数传参。
    根据name 和 sex查询Student信息。
    如果是多个参数的话,mybatis框架底层是怎么做的呢?
    mybatis框架会自动创建一个Map集合。
    并且Map集合是以这种方式存储参数的:
            map.put("arg0",name);
            map.put("arg1",sex);
            map.put("param1",name);
            map.put("param2",sex);*/
    List<Student> selectStudentByNameAndSex(String name, Character sex);

    /*通过注解传参
        根据name 和 sex查询Student信息。
        如果是多个参数的话,mybatis框架底层是怎么做的呢?
        mybatis框架会自动创建一个Map集合。
        并且Map集合是以这种方式存储参数的:
        map.put("name",name);
        map.put("sex",sex);
    */
    List<Student> selectStudentByNameAndSex2(@Param("name") String name, @Param("sex") Character sex);

}
