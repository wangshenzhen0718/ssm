package com.wang.mybatis.test;


import com.wang.mybatis.mapper.StudentMapper;
import com.wang.mybatis.pojo.Student;
import com.wang.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

public class StudentMapperTest {
    private StudentMapper studentMapper = SqlSessionUtil.openSession().getMapper(StudentMapper.class);

    @Test
    public void testSelectById(){
        Student student = studentMapper.getStudentById(1L);
        System.out.println(student);
        System.out.println(student.getSid());
        System.out.println(student.getSname());
        System.out.println(student.getClazz().getCid());
        System.out.println(student.getClazz().getCname());

    }



}
