package com.wang.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author:wsz
 * @Date: 2022/10/29 16:05
 * @Description:
 * @VERSON:jdk17
 */
public class MybatisIntroductionTest {
    public static void main(String[] args) throws IOException {
        //自动会从类的根路径下开始查找资源 Resources.getResourceAsStream底层其实也是ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml")
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        /*
        1.InputStream is = Resources.getResourceAsStream("com/mybatis-config.xml");
        2.InputStream is=new FileInputStream("d:\\mybatis-config.xml")
        3.InputStream is=ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml");*/
        //SqlSessionFactoryBuilder生成SqlSessionFactory
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //默认从类的根目录下查找资源 一般情况下都是一个数据库对应一个SqlSessionFactory对象。
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //SqlSessionFactory生成sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //这种方式实际上是不建议的，因为没有开启事务
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //insertCar为语句唯一id
        sqlSession.insert("insertCar");
        //提交事物
        sqlSession.commit();
    }
}
