package com.wang.mybatis.test;

import com.wang.mybatis.pojo.Car;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

public class ConfigurationTest {

    @Test
    public void testPool() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = build.openSession();
        Car car = new Car();
        car.setCarNum("2222");
        car.setBrand("比亚迪 plus1");
        car.setGuidePrice(20.0);
        car.setProduceTime("2022-10-30");
        car.setCarType("电动车");
        sqlSession.insert("aaa.insertCar",car);
        sqlSession.commit();
        sqlSession.close();

        SqlSession sqlSession2 = build.openSession();
        sqlSession2.insert("aaa.insertCar",car);
        sqlSession2.commit();
        sqlSession2.close();


    }

    @Test
    public void testDelete() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"), "mybatisDB");
        SqlSession sqlSession = build.openSession();
        int delete = sqlSession.delete("aaa.deleteById", 28);
        System.out.println(delete);
        sqlSession.commit();
        sqlSession.close();


    }
}
