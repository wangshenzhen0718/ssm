package com.wang.mybatis.test;

import com.wang.mybatis.mapper.StudentMapper;
import com.wang.mybatis.pojo.Student;
import com.wang.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StudentMapperTest {
    private StudentMapper studentMapper = SqlSessionUtil.openSession().getMapper(StudentMapper.class);

    @Test
    public void testSelectById() {
        List<Student> students = studentMapper.selectStudentById(1);
        students.forEach(student -> System.out.println(student));

    }

    @Test
    public void testSelectByName() {
        List<Student> students = studentMapper.selectStudentByName("李四");
        students.forEach(student -> System.out.println(student));

    }

    @Test
    public void testSelectByBirth() {
    }

    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            parse = sdf.parse("2013-01-23");
            List<Student> students = studentMapper.selectStudentByBirth(parse);
            students.forEach(student -> System.out.println(student));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testSelectBySex() {
        Character sex = Character.valueOf('男');
        List<Student> students = studentMapper.selectStudentBySex(sex);
        students.forEach(student -> System.out.println(student));
    }
}
