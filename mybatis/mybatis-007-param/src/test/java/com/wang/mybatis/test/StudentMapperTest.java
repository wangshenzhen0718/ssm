package com.wang.mybatis.test;

import com.wang.mybatis.mapper.StudentMapper;
import com.wang.mybatis.pojo.Student;
import com.wang.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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

    @Test
    public void testInsertByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "赵六");
        map.put("age", 18);
        map.put("height", 1.88);
        map.put("birth", new Date(2020 - 10 - 10));
        map.put("sex", '女');
        int i = studentMapper.insertStudentByMap(map);
        SqlSessionUtil.openSession().commit();
        SqlSessionUtil.openSession().close();
        System.out.println(i);
    }

    @Test
    public void testInsertByPojo() {
        Student student = new Student(null, "李七", '女', 18, 1.60, new Date(2000 - 01 - 01));
        int i = studentMapper.insertStudentByPojo(student);
        SqlSessionUtil.openSession().commit();
        SqlSessionUtil.openSession().close();
        System.out.println(i);
    }

    /*普通多个参数*/
    @Test
    public void testSelectByNameAndSex() {
        List<Student> students = studentMapper.selectStudentByNameAndSex("张三", '男');
        students.forEach(student -> System.out.println(student));
    }

    /*通过注解传参*/
    @Test
    public void testSelectByNameAndSex2() {
        List<Student> students = studentMapper.selectStudentByNameAndSex2("张三", '男');
        students.forEach(student -> System.out.println(student));
    }
}
