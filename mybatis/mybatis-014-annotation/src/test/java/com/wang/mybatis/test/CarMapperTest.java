package com.wang.mybatis.test;

import com.wang.mybatis.mapper.CarMapper;
import com.wang.mybatis.pojo.Car;
import com.wang.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.math.BigDecimal;

public class CarMapperTest {

    @Test
    public void testInsertByAnno() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null,"9991","凯美瑞",new BigDecimal(100.0),"2022-11-13","燃油车");
        int i = mapper.insertCar(car);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteByIdAnno() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        mapper.deleteCarById(41);
        sqlSession.commit();
        sqlSession.close();


    }

    @Test
    public void testUpdateByAnno() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(39L,"9991","凯美瑞",new BigDecimal(100.0),"2022-11-13","燃油车");
        int i = mapper.updateCar(car);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectByIdAnno() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectCarById(39);
        System.out.println(car);
        sqlSession.commit();
        sqlSession.close();
    }
}
