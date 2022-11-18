package com.wang.mybatis.test;

import com.wang.mybatis.mapper.CarMapper;
import com.wang.mybatis.pojo.Car;
import com.wang.mybatis.pojo.CarExample;
import com.wang.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class CarMapperTest {

    @Test
    public void testselectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectByPrimaryKey(35L);
        System.out.println(car.getBrand());

    }

    @Test
    public void testSelectCriteria() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        CarExample carExample = new CarExample();
        CarExample.Criteria criteria = carExample.createCriteria();
        criteria.andIdBetween(35L,37L);
        for (Car car : mapper.selectByExample(carExample)) {
            System.out.println(car);
        }


    }
}
