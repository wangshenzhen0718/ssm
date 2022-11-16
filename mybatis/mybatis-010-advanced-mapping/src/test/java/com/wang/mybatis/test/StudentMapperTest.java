package com.wang.mybatis.test;


import com.wang.mybatis.mapper.StudentMapper;
import com.wang.mybatis.pojo.Student;
import com.wang.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

public class StudentMapperTest {
    private StudentMapper studentMapper = SqlSessionUtil.openSession().getMapper(StudentMapper.class);

    @Test
    public void testSelectById(){
        Student student = studentMapper.getStudentById(1);
        System.out.println(student);
        System.out.println(student.getSid());
        System.out.println(student.getSname());
        System.out.println(student.getClazz().getCid());
        System.out.println(student.getClazz().getCname());

    }

    @Test
    public void testSelectByAssosition(){
        Student student = studentMapper.getStudentByAssosition(1);
        System.out.println(student);
        System.out.println(student.getSid());
        System.out.println(student.getSname());
        System.out.println(student.getClazz().getCid());
        System.out.println(student.getClazz().getCname());

    }

    @Test
    public void testSelectBySidStep(){
        Student student = studentMapper.selectBySidStep1(1);
        System.out.println(student);
        System.out.println(student.getSid());
        System.out.println(student.getSname());

    }


}
